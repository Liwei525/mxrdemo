package cn.weicao.mxr.service;

import java.util.List;
import java.util.Map;

import cn.weicao.mxr.vo.Dept;
import cn.weicao.mxr.vo.Role;

public interface IDeptService {
	/**
	 * 根据部门编号查找部门信息
	 * @param did 部门编号
	 * @return 部门信息
	 */
	public Dept get(int did) ;
	/**
	 * 根据部门名称查找部门信息
	 * @param did 部门名称
	 * @return 部门信息
	 */
	public Dept getByDname(String dname) ;
	/**
	 * 增加部门
	 * @param dept 部门信息
	 * @return 增加成功返回true
	 */
	public boolean add(Dept dept) ;
	/**
	 * 查询出所有的部门信息
	 * @return 以map形式返回
	 * 1、key = allDepts , value 表示所有的部门信息
	 * 2、key = allEmps , value 表示每个部门对应的领导信息
	 */
	public Map<String,Object> list() ;
	/**
	 * 修改部门信息
	 * @param dept 部门信息
	 * @return 修改成功返回true
	 */
	public boolean edit(Dept dept) ;
	/**
	 * 根据部门编号取得部门的详细信息
	 * @param did 部门编号
	 * @return 以map形式返回
	 * 1、key = dept , value 表示部门信息
	 * 2、key = emp , value 表示部门的领导信息
	 * 3、key = roles , value 表示该部门的所有角色信息
	 * 4、key = actions , value 表示该部门的所有权限信息
	 */
	public Map<String,Object> listDetails(int did) ;
	/**
	 * 根据部门编号取得部门的详细信息
	 * @param did 部门编号
	 * @return 以map形式返回
	 * 1、key = dept , value 表示部门信息
	 * 2、key = emp , value 表示部门的领导信息
	 * 3、key = roles , value 表示该部门的所有角色信息
	 */
	public Map<String,Object> listRoleByDid(int did) ;
	/**
	 * 根据部门编号取得部门不存在的角色信息
	 * @param did 部门编号
	 * @return 该部门不存在的角色信息
	 */
	public List<Role> listRole(int did) ;
	/**
	 * 增加部门角色
	 * @param did 部门编号
	 * @param rid 角色编号
 	 * @return 增加成功返回true
	 */
	public boolean addRole(int did,String rid) ;
	/**
	 * 根据部门编号和角色编号删除角色
	 * @param did 部门编号
	 * @param rid 角色编号
	 * @return 删除成功返回true
	 */
	public boolean deleteRole(int did,String rid) ;
}
