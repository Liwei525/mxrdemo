package cn.weicao.mxr.service;

import java.util.Date;
import java.util.Map;

import cn.weicao.mxr.vo.UCGoods;

public interface IUCGoodsService {
	/**
	 * 根据半成品名称查找半成品信息
	 * @param name 半成品名称
	 * @return 半成品信息
	 */
	public UCGoods getByName(String name) ;
	/**
	 * 半成品增加
	 * @param ucgoods 半成品信息
	 * @return 增加成功返回true
	 */
	public boolean add(UCGoods ucgoods) ;
	/**
	 * 时间分页模糊查询
	 * @param currentPage 当前页
	 * @param lineSize 每页的行数
	 * @param column 模糊查询的列
	 * @param keyWord 模糊查询的关键字
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return 以map形式返回
	 * 1、key = allUCGoods , 所有的半成品信息
	 * 2、key = allRecorders , 所有的录入人员的姓名 
	 */
	public Map<String,Object> list(int currentPage,int lineSize,String column,String keyWord,Date start,Date end) ;
	/**
	 * 根据半成品编号查找半成品信息
	 * @param ucid 半成品编号
	 * @return 半成品信息
	 */
	public UCGoods get(int ucid) ;
	/**
	 * 修改半成品信息
	 * @param ucgoods 半成品信息
	 * @return 修改成功返回true
	 */
	public boolean edit(UCGoods ucgoods) ;
	/**
	 * 根据半成品编号查询出半成品信息
	 * @param ucid 半成品编号
	 * @return 以map的形式返回
	 * 1、key = ucgoods , value 表示半成品信息
	 * 2、key = storageCount , value 表示该半成品的入库次数
	 * 3、key = outputCount , value 表示该半成品的出库次数
	 */
	public Map<String,Object> show(int ucid) ;
	/**
	 * 根据半成品编号查询出该半成品的所有入库信息
	 * @param ucid 半成品编号
	 * @return 以map形式返回
	 * 1、key = allUCGoodsStorageApplyRecord , value 表示所有的半成品入库信息
	 * 2、key = allWarehouse , value 表示入库对应的仓库信息
	 */
	public Map<String,Object> showStorageDetails(int ucid) ;
	/**
	 * 根据半成品编号查询出该半成品的所有出入信息
	 * @param ucid 半成品编号
	 * @return 以map形式返回
	 * 1、key = allUCGoodsOutputRecord, value 表示所有的半成品出库信息
	 * 2、key = allWarehouse , value 表示出库对应的仓库信息
	 * 3、key = allPlant , value 表示出库对应的车间信息
	 */
	public Map<String,Object> showOutputDetails(int ucid) ;
	/**
	 * 根据半成品编号查询出该半成品在所有仓库里的数量信息
	 * @param ucid 半成品编号
	 * @return 以map形式返回
	 * 1、key = allWarehouseUCGoods , value 表示该半成品所有仓库的数量信息
	 * 2、key = allWarehouse , value 表示该半成品所在仓库的信息
	 * 3、key = allProvince , value 表示仓库对应的省份信息
	 * 4、key = allCity , value 表示仓库对应的城市信息
	 */
	public Map<String,Object> ucgoodsNumDetails(int ucid) ;
}
