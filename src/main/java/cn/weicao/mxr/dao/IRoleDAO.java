package cn.weicao.mxr.dao;

import java.util.Map;
import java.util.Set;

import cn.weicao.mxr.vo.Role;

public interface IRoleDAO {
	/**
	 * 根据部门编号查找该部门的所有角色
	 * @param did 部门编号
	 * @return 该部门对应的所有角色
	 */
	public Set<String> findAllByDid(Integer did) ;
	/**
	 * 根据角色编号取得角色信息
	 * @param rid 角色编号
	 * @return 角色信息
	 */
	public Role findById(String rid) ;
	/**
	 * 取得全部的角色信息
	 * @return 所有的角色信息
	 */
	public Set<Role> findAll() ;
	/**
	 * 增加部门角色
	 * @param map 部门角色信息
	 * @return 增加成功返回true
	 */
	public boolean doCreate(Map<String,Object> map) ;
	/**
	 * 删除部门角色
	 * @param map 部门角色信息
	 * @return 删除成功返回true
	 */
	public boolean doRemove(Map<String,Object> map) ;
	
}
