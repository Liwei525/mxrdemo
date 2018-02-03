package cn.weicao.mxr.service;

import java.util.List;
import java.util.Map;

import cn.weicao.mxr.vo.City;
import cn.weicao.mxr.vo.Warehouse;

public interface IWarehouseService {
	/**
	 * 根据仓库编号查询仓库信息
	 * @param wid 仓库编号
	 * @return 以map形式返回
	 * 1、key = warehouse , value 表示仓库信息
	 * 2、key = province , value 表示省份信息
	 * 3、key = city , value 表示城市信息
	 */
	public Map<String,Object> get(int wid) ;
	/**
	 * 增加仓库前的操作
	 * @return 以map形式返回
	 * 1、key = allProvinces , value 表示所有的省份信息
	 */
	public Map<String,Object> addPre() ;
	/**
	 * 根据省份编号查询城市信息
	 * @param pid 省份编号
	 * @return 该省份对应的城市信息
	 */
	public List<City> getCity(int pid) ;
	/**
	 * 根据仓库名称查询仓库信息
	 * @param name 仓库名称
	 * @return 仓库信息
	 */
	public Warehouse get(String name) ;
	/**
	 * 增加仓库
	 * @param warehouse 仓库信息
	 * @return 增加成功返回true
	 */
	public boolean add(Warehouse warehouse) ;
	/**
	 * 仓库的分页模糊查询
	 * @param currentPage 当前页
	 * @param lineSize 每页的行数
	 * @param column 模糊查询的列
	 * @param keyWord 模糊查询的关键字
	 * @return 以map形式返回
	 * 1、key = allWarehouses , value 表示所有的仓库信息
	 * 2、key = allRecorders , value 表示仓库的数量
	 * 3、key = allMembers , value 表示所有的记录者信息
	 */
	public Map<String,Object> list(int currentPage,int lineSize,String column,String keyWord) ;
	/**
	 * 根据仓库编号查询出该仓库所有的半成品信息
	 * @param wid 仓库编号
	 * @param currentPage 当前页
	 * @param lineSize 每页的行数
	 * @return 以map形式返回 
	 * 1、key = allWarehouseUCGoods , value 表示该仓库对应的所有的半成品信息
	 * 2、key = count , value 表示该仓库对应半合成的数量
	 */
	public Map<String,Object> getAllUCGoodsByWid(int wid,int currentPage,int lineSize) ;
	/**
	 * 根据仓库编号进行仓库编辑前的回显操作
	 * @param wid 仓库编号
	 * @return 以map形式返回
	 * 1、key = warehouse , value 表示仓库信息
	 * 2、key = allProvinces , value 表示所有的省份
	 * 3、key = allCitys , value 表示仓库省份对应的所有城市信息
	 */
	public Map<String,Object> editPre(int wid) ;
	/**
	 * 仓库信息的修改
	 * @param warehouse 仓库信息
	 * @return 修改成功返回true
	 */
	public boolean edit(Warehouse warehouse) ;
} 
