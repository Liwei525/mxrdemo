package cn.weicao.mxr.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.weicao.mxr.dao.IActionDAO;
import cn.weicao.mxr.dao.IDeptDAO;
import cn.weicao.mxr.dao.IEmpDAO;
import cn.weicao.mxr.dao.IEmpTypeDAO;
import cn.weicao.mxr.dao.ILevelDAO;
import cn.weicao.mxr.dao.IRoleDAO;
import cn.weicao.mxr.service.IEmpService;
import cn.weicao.mxr.service.abs.AbstractService;
import cn.weicao.mxr.vo.Dept;
import cn.weicao.mxr.vo.Emp;
import cn.weicao.mxr.vo.Level;
@Service
public class EmpServiceImpl extends AbstractService implements IEmpService {
	@Resource
	private IEmpDAO empDAO ;
	@Resource
	private IRoleDAO roleDAO ;
	@Resource
	private IActionDAO actionDAO ;
	@Resource
	private ILevelDAO levelDAO ;
	@Resource
	private IEmpTypeDAO empTypeDAO ;
	@Resource
	private IDeptDAO deptDAO ;
	@Override
	public Emp get(String eid) {
		return this.empDAO.findById(eid);
	}

	@Override
	public Map<String, Set<String>> getRolesAndAction(String eid) {
		Map<String,Set<String>> map = new HashMap<String,Set<String>>() ;
		Emp emp = this.get(eid) ;
		map.put("allRoles", this.roleDAO.findAllByDid(emp.getDid())) ;
		map.put("allActions", this.actionDAO.findAllByDid(emp.getDid())) ;
		return map;
	}

	@Override
	public boolean editLastDate(String eid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("eid", eid) ;
		map.put("lastDate", new Date()) ;
		return this.empDAO.doEditLastDate(map);
	}

	@Override
	public boolean editPassword(String eid, String newPassword) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("eid", eid) ;
		map.put("password", newPassword) ;
		return this.empDAO.doEditPassword(map);
	}

	@Override
	public Map<String, Object> getMyself(String eid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Emp emp = this.get(eid) ;
		map.put("emp", emp) ;
		map.put("deptName", this.deptDAO.findById(emp.getDid()).getDname()) ;
		map.put("levelTitle", this.levelDAO.findById(emp.getLid()).getTitle()) ;
		map.put("empTypeTitle", this.empTypeDAO.findById(emp.getEtid()).getTitle()) ;
		map.put("allRoles", this.roleDAO.findAllByDid(emp.getDid())) ;
		map.put("allActions", this.actionDAO.findAllByDid(emp.getDid())) ;
		return map;
	}

	@Override
	public Map<String, Object> addPre() {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("allDepts", this.deptDAO.findAll()) ;
		map.put("allLevelsNoMaster", this.levelDAO.findAllNoMaster()) ;
		map.put("allEmpTypes", this.empTypeDAO.findAll()) ;
		return map ;
	}

	@Override
	public boolean add(Emp emp) {
		if(emp.getLid() == 0) {
			return false ;
		}
		Dept dept = this.deptDAO.findById(emp.getDid()) ;
		if(dept.getMaxnum() == dept.getCurrnum()) {
			return false ;
		}
		if(emp.getLid() == 1) {
			Emp oldManager = this.empDAO.findById(dept.getEid()) ; //之前的经理信息
			if(oldManager == null) {
				dept.setEid(emp.getEid());
				dept.setCurrnum(dept.getCurrnum() + 1);
				if(this.deptDAO.doEdit(dept)) {
					return this.empDAO.doCreate(emp) ;
				}else {
					return false ;
				}
			}else {
				oldManager.setLid(2);
				if(this.empDAO.doEdit(oldManager)) {
					dept.setEid(emp.getEid());
					dept.setCurrnum(dept.getCurrnum() + 1);
					if(this.deptDAO.doEdit(dept)) {
						return this.empDAO.doCreate(emp) ;
					}else {
						return false ;
					}
				}else {
					return false ;
				}
			}
		}else {
			dept.setCurrnum(dept.getCurrnum() + 1);
			if(this.deptDAO.doEdit(dept)) {
				return this.empDAO.doCreate(emp) ;
			}else {
				return false ;
			}
		}
	}
	
	@Override
	public Map<String, Object> list(int currentPage, int lineSize, String column, String keyWord, Date start, Date end) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<String,Dept> deptNames = new HashMap<String,Dept>() ;
		Map<String,Level> levelTitles = new HashMap<String,Level>() ;
		List<Emp> allEmps = this.empDAO.findSplit(super.converToMap(currentPage, lineSize, column, keyWord, start, end)) ;
		int allRecorders = this.empDAO.getCount(super.converToMap(0, 0, column, keyWord, start, end)) ;
		Iterator<Emp> iter = allEmps.iterator() ;
		while(iter.hasNext()) {
			Emp emp = iter.next() ;
			deptNames.put(emp.getEid(), this.deptDAO.findById(emp.getDid())) ;
			levelTitles.put(emp.getEid(), this.levelDAO.findById(emp.getLid())) ;
		}
		map.put("allEmps", allEmps) ;
		map.put("allRecorders", allRecorders) ;
		map.put("deptNames", deptNames) ;
		map.put("levelTitles", levelTitles) ;
		return map ;
	}
	
	@Override
	public Map<String, Object> editPre(String eid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("emp", this.empDAO.findById(eid)) ;
		map.put("allDepts", this.deptDAO.findAll()) ;
		map.put("allLevelsNoMaster", this.levelDAO.findAllNoMaster()) ;
		map.put("allEmpTypes", this.empTypeDAO.findAll()) ;
		return map ;
	}
	
	@Override
	public boolean edit(Emp emp) {
		Emp oldEmp = this.empDAO.findById(emp.getEid()) ;
		if(oldEmp == null || oldEmp.getLid() == 0 || oldEmp.getState() == 0) {
			return false ;
		}else {
			if(oldEmp.getDid() == emp.getDid()) { //同一个部门之间的修改
				if(oldEmp.getLid() == emp.getLid()) { //职位没有改变
					return this.empDAO.doEdit(emp) ;
				}else { //职位发生改变
					if(oldEmp.getLid() == 1) { //之前是经理，现在不是了
						Dept dept = this.deptDAO.findById(oldEmp.getDid()) ;
						dept.setEid("");
						if(this.deptDAO.doEdit(dept)) {
							return this.empDAO.doEdit(emp) ;
						}else {
							return false ;
						}
					}else { //之前不是经理，现在是了
						Dept dept = this.deptDAO.findById(oldEmp.getDid()) ;
						Emp oldEid = this.empDAO.findById(dept.getEid()) ; //之前的经理
						oldEid.setLid(2); //将之前的经理变为普通员工
						dept.setEid(emp.getEid());
						if(this.deptDAO.doEdit(dept) && this.empDAO.doEdit(oldEid)) {
							return this.empDAO.doEdit(emp) ;
						}else {
							return false ;
						}
					}
				}
			}else { //不同部门之间的修改
				if(oldEmp.getLid() == 1 && emp.getLid() == 1) { //之前是经理，现在还是经理
					Dept oldDept = this.deptDAO.findById(oldEmp.getDid()) ; //之前的部门信息
					Dept newDept = this.deptDAO.findById(emp.getDid()) ; // 现在的部门信息
					if(newDept.getCurrnum() >= newDept.getMaxnum()) {
						return false ;
					}
					Emp oldEid = this.empDAO.findById(newDept.getEid()) ; //要转部门的经理信息
					oldEid.setLid(2); //将经理变为普通员工
					oldDept.setCurrnum(oldDept.getCurrnum() - 1);
					oldDept.setEid("");
					newDept.setCurrnum(newDept.getCurrnum() + 1);
					newDept.setEid(emp.getEid());
					if(this.deptDAO.doEdit(oldDept) && this.deptDAO.doEdit(newDept) && this.empDAO.doEdit(oldEid)) {
						return this.empDAO.doEdit(emp) ;
					}else {
						return false ;
					}
				}else if(oldEmp.getLid() == 1 && emp.getLid() == 2) { //之前是经理，现在是员工
					Dept oldDept = this.deptDAO.findById(oldEmp.getDid()) ; //之前的部门信息
					Dept newDept = this.deptDAO.findById(emp.getDid()) ; // 现在的部门信息
					if(newDept.getCurrnum() >= newDept.getMaxnum()) {
						return false ;
					}
					oldDept.setCurrnum(oldDept.getCurrnum() - 1);
					oldDept.setEid("");
					newDept.setCurrnum(newDept.getCurrnum() + 1);
					if(this.deptDAO.doEdit(oldDept) && this.deptDAO.doEdit(newDept)) {
						return this.empDAO.doEdit(emp) ;
					}else {
						return false ;
					}
				}else if(oldEmp.getLid() == 2 && emp.getLid() == 1) { //之前是员工，现在是经理
					Dept oldDept = this.deptDAO.findById(oldEmp.getDid()) ; //之前的部门信息
					Dept newDept = this.deptDAO.findById(emp.getDid()) ; // 现在的部门信息
					if(newDept.getCurrnum() >= newDept.getMaxnum()) {
						return false ;
					}
					Emp oldEid = this.empDAO.findById(newDept.getEid()) ; //要转部门的经理信息
					oldEid.setLid(2); //将经理变为普通员工
					oldDept.setCurrnum(oldDept.getCurrnum() - 1);
					newDept.setCurrnum(newDept.getCurrnum() + 1);
					newDept.setEid(emp.getEid());
					if(this.deptDAO.doEdit(oldDept) && this.deptDAO.doEdit(newDept) && this.empDAO.doEdit(oldEid)) {
						return this.empDAO.doEdit(emp) ;
					}else {
						return false ;
					}
				}else { //之前是员工，现在还是员工
					Dept oldDept = this.deptDAO.findById(oldEmp.getDid()) ; //之前的部门信息
					Dept newDept = this.deptDAO.findById(emp.getDid()) ; // 现在的部门信息
					if(newDept.getCurrnum() >= newDept.getMaxnum()) {
						return false ;
					}
					oldDept.setCurrnum(oldDept.getCurrnum() - 1);
					newDept.setCurrnum(newDept.getCurrnum() + 1);
					if(this.deptDAO.doEdit(oldDept) && this.deptDAO.doEdit(newDept)) {
						return this.empDAO.doEdit(emp) ;
					}else {
						return false ;
					}
				}
			}
		}
	}
	
	@Override
	public boolean state(String eid, String leaveDate, String leaveNote, String outeid) {
		Emp emp = this.empDAO.findById(eid) ;
		try {
			emp.setLeaveDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(leaveDate));
		} catch (ParseException e) {}
		emp.setLeaveNote(leaveNote);
		emp.setOuteid(outeid);
		emp.setState(0);
		Dept dept = this.deptDAO.findById(emp.getDid()) ;
		if(emp.getLid() == 1 && eid.equals(dept.getEid())) { //经理离职
			dept.setEid("");
		}
		dept.setCurrnum(dept.getCurrnum() - 1);
		if(this.deptDAO.doEdit(dept)) {
			return this.empDAO.doEdit(emp) ;
		}else {
			return false ;
		}
		
	}
}
