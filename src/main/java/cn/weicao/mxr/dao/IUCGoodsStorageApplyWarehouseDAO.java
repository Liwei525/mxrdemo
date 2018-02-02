package cn.weicao.mxr.dao;

import java.util.List;

import cn.weicao.mxr.vo.UCGoodsStorageApplyWarehouse;

public interface IUCGoodsStorageApplyWarehouseDAO {
	/**
	 * 根据合同号查询出所有的入库申请单编号
	 * @param usaid 合同号
	 * @return 所有的入库申请单编号
	 */
	public List<String> findByUsaid(String usaid) ;
	/**
	 * 根据入库申请单号查询的入库的详细信息
	 * @param usawid 入库申请单号
	 * @return 入库的详细信息
	 */
	public UCGoodsStorageApplyWarehouse findById(String usawid) ;
	/**
	 * 增加合同-入库单表记录
	 * @param ucgoodsStorageApplyWarehouse 合同-入库单表
	 * @return 增加成功返回true
	 */
	public boolean doCreate(UCGoodsStorageApplyWarehouse ucgoodsStorageApplyWarehouse) ;
}
