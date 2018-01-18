package cn.weicao.mxr.dao;

import java.util.Set;

public interface IActionDAO {
	/**
	 * 根据部门编号查找该部门对应的所有权限
	 * @param did 部门编号
	 * @return 该部门对应的所有权限
	 */
	public Set<String> findAllByDid(Integer did) ;
}
