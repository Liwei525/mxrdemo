package cn.weicao.mxr.dao;

import cn.weicao.mxr.vo.UCGoodsStorageApplyDetails;

public interface IUCGoodsStorageApplyDetailsDAO {
	/**
	 * 增加半成品入库详细记录
	 * @param ucgoodsStorageApplyRecord 半成品详细信息
	 * @return 增加成功返回true
	 */
	public boolean doCreate(UCGoodsStorageApplyDetails ucgoodsStorageApplyDetails) ;
}
