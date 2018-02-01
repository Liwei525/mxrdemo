package cn.weicao.mxr.dao;

import java.util.List;
import java.util.Map;

import cn.weicao.mxr.vo.UCGoodsStorageApply;

public interface IUCGoodsStorageApplyDAO {
	/**
	 * 根据合同号取得入库申请单信息
	 * @param usaid 合同号
	 * @return 入库申请单信息
	 */
	public UCGoodsStorageApply findById(String usaid) ;
	/**
	 * 增加入库申请单
	 * @param ucgoodsStorageApply 入库申请单信息
	 * @return 增加成功返回true
	 */
	public boolean doCreate(UCGoodsStorageApply ucgoodsStorageApply) ;
	/**
	 * 时间分页模糊查询
	 * @param map 包含有时间分页模糊数据
	 * @return 满足条件的所有入库申请单信息
	 */
	public List<UCGoodsStorageApply> findSplit(Map<String,Object> map) ;
	/**
	 * 修改入库申请单
	 * @param ucgoodsStorageApply 入库申请单信息
	 * @return 修改成功返回true
	 */
	public boolean doEdit(UCGoodsStorageApply ucgoodsStorageApply) ;
	/**
	 * 根据合同号删除入库申请单
	 * @param usaid 合同号
	 * @return 删除成功返回true
	 */
	public boolean doRemove(String usaid) ;
}