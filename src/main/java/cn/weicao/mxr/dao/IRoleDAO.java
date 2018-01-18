package cn.weicao.mxr.dao;

import java.util.Set;

public interface IRoleDAO {
	/**
	 * 根据部门编号查找该部门的所有角色
	 * @param did 部门编号
	 * @return 该部门对应的所有角色
	 */
	public Set<String> findAllByDid(Integer did) ;
}
