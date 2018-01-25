package cn.weicao.mxr.dao;

import java.util.List;

import cn.weicao.mxr.vo.UCGoodsStorageApplyRecord;

public interface IUCGoodsStorageApplyRecordDAO {
	/**
	 * 根据半成品编号查询出该半成品所有的入库记录
	 * @param ucid 半成品编号
	 * @return 该半成品所有的入库记录
	 */
	public List<UCGoodsStorageApplyRecord> findByUcid(Integer ucid) ;
}
