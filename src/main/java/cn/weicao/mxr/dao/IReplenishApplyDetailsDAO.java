package cn.weicao.mxr.dao;

import java.util.List;

import cn.weicao.mxr.vo.ReplenishApplyDetails;

public interface IReplenishApplyDetailsDAO {
	/**
	 * 增加半成品补货详细记录
	 * @param replenishApplyDetails 半成品详细信息
	 * @return 增加成功返回true
	 */
	public boolean doCreate(ReplenishApplyDetails replenishApplyDetails) ;
	/**
	 * 根据补货单号查询出所有对应的半成品详情
	 * @param raid 补货单号
	 * @return 所有对应的半成品详情
	 */
	public List<ReplenishApplyDetails> findByRaid(Integer raid) ;
}
