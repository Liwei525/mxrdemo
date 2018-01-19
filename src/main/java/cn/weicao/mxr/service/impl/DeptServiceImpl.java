package cn.weicao.mxr.service.impl;

import java.util.ArrayList;
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
import cn.weicao.mxr.dao.IRoleDAO;
import cn.weicao.mxr.service.IDeptService;
import cn.weicao.mxr.service.abs.AbstractService;
import cn.weicao.mxr.vo.Action;
import cn.weicao.mxr.vo.Dept;
import cn.weicao.mxr.vo.Emp;
import cn.weicao.mxr.vo.Role;
@Service
public class DeptServiceImpl extends AbstractService implements IDeptService{
	@Resource
	private IDeptDAO deptDAO ;
	@Resource
	private IEmpDAO empDAO ;
	@Resource
	private IRoleDAO roleDAO ;
	@Resource
	private IActionDAO actionDAO ;
	@Override
	public Dept get(int did) {
		return this.deptDAO.findById(did);
	}
	@Override
	public Dept getByDname(String dname) {
		return this.deptDAO.findByDname(dname) ;
	}
	@Override
	public boolean add(Dept dept) {
		if(this.getByDname(dept.getDname()) == null) {
			return this.deptDAO.doCreate(dept);
		}else {
			return false ;
		}
	}
	@Override
	public Map<String, Object> list() {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<Integer,Emp> allEmps = new HashMap<Integer,Emp>() ;
		List<Dept> allDepts = this.deptDAO.findAll() ;
		Iterator<Dept> iter = allDepts.iterator() ;
		while(iter.hasNext()) {
			Dept dept = iter.next() ;
			allEmps.put(dept.getDid(), this.empDAO.findById(dept.getEid())) ;
		}
		map.put("allDepts", allDepts) ;
		map.put("allEmps", allEmps) ;
		return map ;
	}
	@Override
	public boolean edit(Dept dept) {
		return this.deptDAO.doEdit(dept);
	}
	@Override
	public Map<String, Object> listDetails(int did) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<String,Object> allRoles = new HashMap<String,Object>();
		List<Action> allActions = new ArrayList<Action>() ;
		Dept dept = this.deptDAO.findById(did) ;
		Set<String> allRolesId = this.roleDAO.findAllByDid(did) ;
		Iterator<String> allRolesIdIter = allRolesId.iterator() ;
		while(allRolesIdIter.hasNext()) {
			String rid = allRolesIdIter.next() ;
			allRoles.put(rid,this.roleDAO.findById(rid)) ;
			Set<Action> allActionsId = this.actionDAO.findAllByRid(rid) ;
			Iterator<Action> allActionsIdIter = allActionsId.iterator() ;
			while(allActionsIdIter.hasNext()) {
				allActions.add(allActionsIdIter.next()) ;
			}
		}
		map.put("dept", dept) ;
		map.put("emp", this.empDAO.findById(dept.getEid())) ;
		map.put("allRoles", allRoles) ;
		map.put("allActions", allActions) ;
		return map ;
	}
	@Override
	public Map<String, Object> listRoleByDid(int did) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		List<Role> allRoles = new ArrayList<Role>() ;
		Dept dept = this.deptDAO.findById(did) ;
		Set<String> allRolesId = this.roleDAO.findAllByDid(did) ;
		Iterator<String> iter = allRolesId.iterator() ;
		while(iter.hasNext()) {
			allRoles.add(this.roleDAO.findById(iter.next())) ;
		}
		map.put("dept", dept) ;
		map.put("emp", this.empDAO.findById(dept.getEid())) ;
		map.put("allRoles", allRoles) ;
		return map ;
	}
	@Override
	public List<Role> listRole(int did) {
		List<Role> remainRoles = new ArrayList<Role>() ;
		Set<Role> allRoles = this.roleDAO.findAll() ;
		Set<String> rolesBydid = this.roleDAO.findAllByDid(did) ;
		Iterator<Role> iter = allRoles.iterator() ;
		while(iter.hasNext()) {
			Role role = iter.next() ;
			if(!rolesBydid.contains(role.getRid())) {
				remainRoles.add(role) ;
			}
		}
		return remainRoles ;
	}
	@Override
	public boolean addRole(int did, String rid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("did", did) ;
		map.put("rid", rid) ;
		return this.roleDAO.doCreate(map) ;
	}
	@Override
	public boolean deleteRole(int did, String rid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("did", did) ;
		map.put("rid", rid) ;
		return this.roleDAO.doRemove(map) ;
	}
}
