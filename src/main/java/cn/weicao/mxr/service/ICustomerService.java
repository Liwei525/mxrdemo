package cn.weicao.mxr.service;

import java.util.List;
import java.util.Map;

import cn.weicao.mxr.vo.City;
import cn.weicao.mxr.vo.Customer;

public interface ICustomerService {
	/**
	 * 公司增加前的一些操作
	 * @return 以map形式返回
	 * 1、key = allCitems , value 表示所有的客户等级表
	 * 2、key = allProvinces , value 表示所有的省份信息
	 */
	public Map<String,Object> addPre() ;
	/**
	 * 根据省份编号查找该省份对应的所有城市信息
	 * @param pid 省份编号
	 * @return 该省份对应的所有城市信息
	 */
	public List<City> getCity(int pid) ;
	/**
	 * 根据公司编号查找公司信息
	 * @param ctid 公司编号
	 * @return 公司信息
	 */
	public Customer get(int ctid) ;
	/**
	 * 根据公司名称查找公司信息
	 * @param name 公司名称
	 * @return 公司信息
	 */
	public Customer get(String name) ;
	/**
	 * 增加公司
	 * @param customer 公司信息
	 * @return 增加成功返回true
	 */
	public boolean add(Customer customer) ;
	/**
	 * 分页模糊查询公司
	 * @param currentPage 当前页
	 * @param lineSize 每页的行数
	 * @param column 模糊查询的列
	 * @param keyWord 模糊查询的关键字
	 * @return 以map形式返回
	 * 1、key = allCustomers , value 表示所有的客户
	 * 2、key = allRecorders , value 表示客户记录数
	 * 2、key = allCitems , value 表示所有的客户重要性
	 */
	public Map<String,Object> list(int currentPage,int lineSize,String column,String keyWord) ;
	/**
	 * 编辑前的回显操作
	 * @param ctid 公司编号
	 * @return 以map形式返回
	 * 1、key = customer , value 表示公司信息
	 * 2、key = allCitems , value 表示公司重要性
	 * 3、key = allProvinces , value 表示所有的省份信息
	 * 4、key = allCity , value 表示该省份所有的城市信息
	 */
	public Map<String,Object> editPre(int ctid) ;
	/**
	 * 编辑公司
	 * @param customer 公司信息
	 * @return 编辑成功返回true
	 */
	public boolean edit(Customer customer) ;
	/**
	 * 删除公司
	 * @param ctid 公司编号
	 * @return 删除成功返回true
	 */
	public boolean remove(int ctid) ;
	/**
	 * 公司的详细列表
	 * @param ctid 公司编号
	 * @return 以map形式返回
	 * 1、key = customer , value 表示公司详情
	 * 2、key = citem , value 表示公司等级
	 * 3、key = recorder , value 表示记录者信息
	 */
	public Map<String,Object> listDetails(int ctid) ;
}
