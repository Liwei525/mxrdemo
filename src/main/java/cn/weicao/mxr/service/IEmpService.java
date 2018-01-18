package cn.weicao.mxr.service;

import java.util.Map;
import java.util.Set;

import cn.weicao.mxr.vo.Emp;

public interface IEmpService {
	/**
	 * 根据雇员编号取得雇员信息
	 * @param eid 雇员编号
	 * @return 雇员信息
	 */
	public Emp get(String eid) ;
	/**
	 * 根据雇员编号找到雇员的部门编号，而后查找对应的角色和权限
	 * @param eid 雇员编号
	 * @return 以map形式返回
	 * 1、key = allRoles , value 表示所有的角色信息
	 * 2、key = allActions , value 表示所有的权限信息 
	 */
	public Map<String,Set<String>> getRolesAndAction(String eid) ;
	/**
	 * 根据雇员编号修改最后一次登录时间
	 * @param eid 雇员编号
	 * @return 修改成功返回true
	 */
	public boolean editLastDate(String eid) ;
	/**
	 * 根据雇员编号修改雇员密码
	 * @param eid 雇员编号
	 * @param newPassword 雇员密码
	 * @return 修改成功返回true
	 */
	public boolean editPassword(String eid,String newPassword) ;
	/**
	 * 根据雇员编号取得雇员的全部信息
	 * @param eid 雇员编号
	 * @return 以map形式返回
	 * 1、key = emp , value 表示雇员的基础信息
	 * 2、key = deptName, value 表示雇员的部门名称
	 * 3、key = levelTitle, value 表示雇员的等级名称
	 * 4、key = empTypeTitle, value 表示雇员的工种名称
	 * 5、key = allRoles , value 表示所有的角色信息
	 * 6、key = allActions , value 表示所有的权限信息 
	 */
	public Map<String,Object> getMyself(String eid) ;
}
