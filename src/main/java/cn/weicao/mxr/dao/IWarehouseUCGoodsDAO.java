package cn.weicao.mxr.dao;

import java.util.List;
import java.util.Map;

import cn.weicao.mxr.vo.WarehouseUCGoods;

public interface IWarehouseUCGoodsDAO {
	/**
	 * 根据半成品编号查询出该半成品在所有的仓库的数量
	 * @param ucid 半成品编号
	 * @return 该半成品在所有的仓库的数量
	 */
	public List<WarehouseUCGoods> findByUcid(Integer ucid) ;
	/**
	 * 根据仓库编号和半成品编号查询出该半成品在该仓库的信息
	 * @param param 里面包含有仓库编号和半成品编号
	 * @return 该半成品在该仓库的信息
	 */
	public WarehouseUCGoods findByWidAndUcid(Map<String,Object> param) ;
	/**
	 * 创建仓库-半成品信息
	 * @param warehouseUCGoods 仓库-半成品信息
	 * @return 增加成功返回true
	 */
	public boolean doCreate(WarehouseUCGoods warehouseUCGoods) ;
	/**
	 * 修改仓库-半成品信息
	 * @param warehouseUCGoods 仓库-半成品信息
	 * @return 修改成功返回true
	 */
	public boolean doEdit(WarehouseUCGoods warehouseUCGoods) ;
}
