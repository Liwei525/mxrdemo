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
	 * 时间模糊查询的数据量
	 * @param map 有时间模糊参数
	 * @return 数据量
	 */
	public int getCount(Map<String,Object> map) ;
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
	/**
	 * 根据时间模糊分页以及状态查询入库申请单信息
	 * @param map 里面包含有时间日期分页以及状态
	 * @return 返回查询的结果
	 */
	public List<UCGoodsStorageApply> findSplitByStatus(Map<String,Object> map) ;
	/**
	 * 根据时间模糊状态查询入库申请单的数量
	 * @param map 有时间模糊状态的信息
	 * @return 返回查询的数据量
	 */
	public int getCountByStatus(Map<String,Object> map) ;
	/**
	 * 入库申请单模糊查询（状态为3和4）
	 * @param keyWord 关键字
	 * @return 返回查询的结果
	 */
	public List<UCGoodsStorageApply> usaidLikeByStatus3AndStatus4(String keyWord) ;
}
