package cn.weicao.mxr.dao;

import java.util.List;

import cn.weicao.mxr.vo.UCGoodsOutputRecord;

public interface IUCGoodsOutputRecordDAO {
	/**
	 * 根据半成品编号查询该半成品所有的出库记录
	 * @param ucid 半成品编号
	 * @return 该半成品所有的出库记录
	 */
	public List<UCGoodsOutputRecord> findByUcid(Integer ucid) ;
}
