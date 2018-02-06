package cn.weicao.mxr.dao;

import java.util.List;
import java.util.Map;

import cn.weicao.mxr.vo.Customer;

public interface ICustomerDAO {
	/**
	 * 根据公司编号查找公司信息
	 * @param ctid 公司编号
	 * @return 公司信息
	 */
	public Customer findById(Integer ctid) ;
	/**
	 * 根据公司名称查找公司信息
	 * @param cname 公司名称
	 * @return 公司信息
	 */
	public Customer findByName(String cname) ;
	/**
	 * 增加公司
	 * @param customer 公司信息
	 * @return 增加成功返回true
	 */
	public boolean doCreate(Customer customer) ;
	/**
	 * 分页模糊查询
	 * @param param 里面有分页模糊参数
	 * @return 返回满足条件的公司
	 */
	public List<Customer> findSplit(Map<String,Object> param) ;
	/**
	 * 模糊查询的数量
	 * @param param 里面有模糊参数
	 * @return 返回公司数量
	 */
	public Integer getCount(Map<String,Object> param) ;
	/**
	 * 修改公司信息
	 * @param customer 公司信息
	 * @return 修改成功返回true
	 */
	public boolean doEdit(Customer customer) ;
	/**
	 * 删除公司
	 * @param ctid 公司编号
	 * @return 删除成功返回true
	 */
	public boolean doRemove(int ctid) ;
}
