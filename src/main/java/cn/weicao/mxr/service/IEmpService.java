package cn.weicao.mxr.service;

import java.util.Date;
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
	/**
	 * 增加雇员前的准备工作
	 * @return 以map形式返回
	 * 1、key = allDepts , value 表示所有的部门信息
	 * 2、key = allLevelsNoMaster , value 表示所有不包含总裁的雇员职位信息
	 * 3、key = allEmpTypes , value 表示所有的工种信息
	 */
	public Map<String,Object> addPre() ;
	/**
	 * 增加雇员
	 * 1、不允许增加总裁
	 * 2、需要判断部门人数是否已满
	 * 3、判断增加的雇员是员工还是经理，如果是经理则需判断该部门是否已有经理，如有经理则替换，之前的经理变为该部门的普通员工
	 * @param emp 雇员信息
	 * @return 增加成功返回true
	 */
	public boolean add(Emp emp) ;
	/**
	 * 雇员列表
	 * @param currentPage 当前页
	 * @param lineSize 每页的行数
	 * @param column 模糊查询的行
	 * @param keyWord 模糊查询的关键字
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return 以map形式返回
	 * 1、key = levelTitles , value 表示雇员对应的级别名称
	 * 2、key = deptNames , value 表示雇员所在部门名称
	 * 3、key = allEmps , value 表示所有的雇员
	 */
	public Map<String,Object> list(int currentPage,int lineSize,String column,String keyWord,Date start,Date end) ;
	/**
	 * 修改雇员前的回显操作
	 * @param eid 雇员编号
	 * @return 以map形式返回
	 * 1、key = emp , value 表示该雇员的信息
	 * 2、key = allDepts , value 表示所有的部门信息
	 * 3、key = allLevelsNoMaster , value 表示所有不包含总裁的雇员职位信息
	 * 4、key = allEmpTypes , value 表示所有的工种信息
	 */
	public Map<String,Object> editPre(String eid) ;
	/**
	 * 修改雇员
	 * 1、本部门之间的修改，则不需要修改部门人数
	 * 2、跨部门之间的修改，则需要修改部门人数
	 * 3、需判断修改之前是否是经理以及是否修改为部门经理
	 * @param emp 雇员信息
	 * @return 修改成功返回true
	 */
	public boolean edit(Emp emp) ;
	/**
	 * 离职操作
	 * @param eid 离职人编号
	 * @param leaveDate 离职日期
	 * @param leaveNote 离职备注
	 * @param outeid 办理离职的雇员
	 * @return 离职成功返回true
	 */
	public boolean state(String eid,String leaveDate,String leaveNote,String outeid) ;
}
