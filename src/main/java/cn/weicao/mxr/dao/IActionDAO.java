package cn.weicao.mxr.dao;

import java.util.Set;

import cn.weicao.mxr.vo.Action;

public interface IActionDAO {
	/**
	 * 根据部门编号查找该部门对应的所有权限
	 * @param did 部门编号
	 * @return 该部门对应的所有权限
	 */
	public Set<String> findAllByDid(Integer did) ;
	/**
	 * 根据角色编号查找所有的权限信息
	 * @param rid 角色编号
	 * @return 该角色对应的所有权限信息
	 */
	public Set<Action> findAllByRid(String rid) ;
}
