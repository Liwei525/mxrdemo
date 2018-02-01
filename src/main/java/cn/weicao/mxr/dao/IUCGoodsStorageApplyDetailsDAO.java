package cn.weicao.mxr.dao;

import java.util.List;
import java.util.Map;

import cn.weicao.mxr.vo.UCGoodsStorageApplyDetails;

public interface IUCGoodsStorageApplyDetailsDAO {
	/**
	 * 增加半成品入库详细记录
	 * @param ucgoodsStorageApplyRecord 半成品详细信息
	 * @return 增加成功返回true
	 */
	public boolean doCreate(UCGoodsStorageApplyDetails ucgoodsStorageApplyDetails) ;
	/**
	 * 根据合同号查询出所有对应的半成品详情
	 * @param usaid 合同号
	 * @return 所有对应的半成品详情
	 */
	public List<UCGoodsStorageApplyDetails> findByUsaid(String usaid) ;
	/**
	 * 根据合同号查询半成品种类的数据量
	 * @param usaid 合同号
	 * @return 半成品种类的数据量
	 */
	public Integer getCountByUsaid(String usaid) ;
	/**
	 * 根据合同号分页查询半成品详情
	 * @param map 里面有合同号以及分页的信息
	 * @return 返回查询的结果
	 */
	public List<UCGoodsStorageApplyDetails> findSplitByUsaid(Map<String,Object> map) ;
	/**
	 * 根据合同号删除半成品信息
	 * @param usaid 合同号
 	 * @return 删除成功返回true
	 */
	public boolean doRemove(String usaid) ;
}
