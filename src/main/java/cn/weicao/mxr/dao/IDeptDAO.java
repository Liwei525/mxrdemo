package cn.weicao.mxr.dao;

import java.util.List;

import cn.weicao.mxr.vo.Dept;

public interface IDeptDAO {
	/**
	 * 根据部门编号查找部门信息
	 * @param did 部门编号
	 * @return 部门信息
	 */
	public Dept findById(Integer did) ;
	/**
	 * 根据部门名称查找部门信息
	 * @param did 部门名称
	 * @return 部门信息
	 */
	public Dept findByDname(String dname) ;
	/**
	 * 增加部门
	 * @param dept 部门信息
	 * @return 增加成功返回true
	 */
	public boolean doCreate(Dept dept) ;
	/**
	 * 查询出所有的部门信息
	 * @return 部门信息
	 */
	public List<Dept> findAll() ;
	/**
	 * 根据部门编号修改部门信息
	 * @param dept 部门信息
	 * @return 修改成功返回true
	 */
	public boolean doEdit(Dept dept) ;
}
