package cn.weicao.mxr.dao;

import java.util.List;
import java.util.Map;

import cn.weicao.mxr.vo.ReplenishApply;

public interface IReplenishApplyDAO {
	/**
	 * 创建补货申请单
	 * @param replenishApply 补货申请单信息
	 * @return 增加成功返回true
	 */
	public boolean doCreate(ReplenishApply replenishApply) ;
	/**
	 * 根据日期分页模糊查询
	 * @param map 里面有日期分页模糊的参数
	 * @return 满足条件的补货单
	 */
	public List<ReplenishApply> findSplit(Map<String,Object> map) ;
	/**
	 * 日期模糊查询的数据量
	 * @param map 里面有日期模糊参数
	 * @return 返回数据量
	 */
	public int getCount(Map<String,Object> map) ;
	/**
	 * 根据补货单号查询补货的信息
	 * @param raid 补货单号
	 * @return 补货信息
	 */
	public ReplenishApply findById(Integer raid) ;
	/**
	 * 修改补货表
	 * @param replenishApply 补货申请单信息
	 * @return 修改成功返回true
	 */
	public boolean doEdit(ReplenishApply replenishApply) ;
	/**
	 * 删除补货申请单
	 * @param raid 补货单号
	 * @return 删除成功返回true
	 */
	public boolean doRemove(Integer raid) ;
	/**
	 * 根据日期分页状态模糊查询
	 * @param map 里面有日期模糊状态的参数
	 * @return 满足条件的补货单
	 */
	public List<ReplenishApply> findSplitByStatus(Map<String,Object> map) ;
	/**
	 * 日期模糊状态查询的数据量
	 * @param map 里面有日期模糊状态参数
	 * @return 返回数据量
	 */
	public int getCountByStatus(Map<String,Object> map) ;
}
