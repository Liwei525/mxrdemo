package cn.weicao.mxr.service.impl;

import java.util.Date;
import java.util.HashMap;
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
import cn.weicao.mxr.vo.Emp;
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
		map.put("lastdate", new Date()) ;
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

}
