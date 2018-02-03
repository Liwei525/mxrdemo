package cn.weicao.mxr.dao;

import java.util.List;
import java.util.Map;

import cn.weicao.mxr.vo.Emp;

public interface IEmpDAO {
	/**
	 * 根据雇员编号查找雇员信息
	 * @param eid 雇员编号
	 * @return 雇员信息
	 */
	public Emp findById(String eid) ;
	/**
	 * 根据雇员编号修改雇员的最后一次登录时间
	 * @param map 里面包含有雇员编号和当前时间
	 * @return 修改成功返回true
	 */
	public boolean doEditLastDate(Map<String,Object> map) ;
	/**
	 * 根据雇员编号修改雇员的密码
	 * @param map 里面包含有雇员编号和雇员密码
	 * @return 修改成功返回true
	 */
	public boolean doEditPassword(Map<String,Object> map) ;
	/**
	 * 修改雇员信息
	 * @param emp 雇员信息
	 * @return 修改成功返回true
	 */
	public boolean doEdit(Emp emp) ;
	/**
	 * 增加雇员
	 * @param emp 雇员信息
	 * @return 增加成功返回true
	 */
	public boolean doCreate(Emp emp) ;
	/**
	 * 日期分页模糊查询
	 * @param map 里面包含有日期分页模糊的信息
	 * @return 列出满足条件的雇员信息
	 */
	public List<Emp> findSplit(Map<String,Object> map) ;
	/**
	 * 时间模糊查询的数据量
	 * @param map 时间模糊参数
	 * @return 数据量
	 */
	public Integer getCount(Map<String,Object> map) ;
}
