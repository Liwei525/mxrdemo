package cn.weicao.mxr.dao;

import java.util.List;

import cn.weicao.mxr.vo.WarehouseUCGoods;

public interface IWarehouseUCGoodsDAO {
	/**
	 * 根据半成品编号查询出该半成品在所有的仓库的数量
	 * @param ucid 半成品编号
	 * @return 该半成品在所有的仓库的数量
	 */
	public List<WarehouseUCGoods> findByUcid(Integer ucid) ;
}
