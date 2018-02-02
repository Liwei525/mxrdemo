package cn.weicao.mxr.service;

import java.util.List;
import java.util.Map;

import cn.weicao.mxr.vo.UCGoodsStorageApply;

public interface IUCGoodsManageService {
	/**
	 * 入库申请单的模糊查询（状态为3和4）
	 * @param keyWord 关键字
	 * @return 返回满足的结果
	 */
	public List<UCGoodsStorageApply> usaidLike(String keyWord) ;
	/**
	 * 入库详情
	 * @param usaid 合同号
	 * @return 以map形式返回
	 * 1、key = ucgoodsStorageApply , value 表示入库申请单信息
	 * 2、key = warehouse , value 表示要入库的仓库信息
	 * 3、key = allUsawid , value 表示所有的入库申请单编号
	 * 4、key = restUcgoods , value 表示未入库的半成品信息
	 */
	public Map<String,Object> storageDetails(String usaid) ;
	/**
	 * 入库申请单号的保存
	 * @param usaid 合同号
	 * @param usawid 入库单号
	 * @param note 入库备注
	 * @param mid 入库人
	 * @return 保存成功返回true
	 */
	public boolean usawidSave(String usaid,String usawid,String note,String mid) ;
	/**
	 * 保存半成品
	 * @param usaid 合同号
	 * @param usawid 入库单号
	 * @param ucid 半成品单号
	 * @param num 实际数量
	 * @return 保存成功返回true
	 */
	public boolean ucidSave(String usaid,String usawid,int ucid,int num) ;
}
