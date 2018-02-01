package cn.weicao.mxr.dao;

import java.util.List;
import java.util.Map;

import cn.weicao.mxr.vo.UCGoodsStorageApplyRecord;

public interface IUCGoodsStorageApplyRecordDAO {
	/**
	 * 根据半成品编号查询出该半成品所有的入库记录
	 * @param ucid 半成品编号
	 * @return 该半成品所有的入库记录
	 */
	public List<UCGoodsStorageApplyRecord> findByUcid(Integer ucid) ;
	/**
	 * 根据入库申请单号查询出对应的半成品信息（分页）
	 * @param usawid 入库申请单编号
	 * @return 查询的结果
	 */
	public List<UCGoodsStorageApplyRecord> findByUsawid(Map<String,Object> map) ;
	/**
	 * 根据入库申请单号统计出半成品信息量
	 * @param usawid 入库申请单号
	 * @return 半成品统计量
	 */
	public Integer getCountByUsawid(String usawid) ;
}
