package cn.weicao.mxr.dao;

import cn.weicao.mxr.vo.Dept;

public interface IDeptDAO {
	/**
	 * 根据部门名称查找部门信息
	 * @param did 部门编号
	 * @return 部门信息
	 */
	public Dept findById(Integer did) ;
}
