package cn.weicao.mxr.service;

import cn.weicao.mxr.vo.UCGoodsStorageApplyWarehouse;

public interface IUCGoodsStorageApplyWarehouseService {
	/**
	 * 根据入库申请单号查询合同-入库申请单信息
	 * @param usawid 入库申请单
	 * @return 合同-入库申请单信息
	 */
	public UCGoodsStorageApplyWarehouse get(String usawid) ;
}
