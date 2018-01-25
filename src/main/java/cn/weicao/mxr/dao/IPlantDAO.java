package cn.weicao.mxr.dao;

import cn.weicao.mxr.vo.Plant;

public interface IPlantDAO {
	/**
	 * 根据车间编号查询车间信息
	 * @param plid 车间编号
	 * @return 车间信息
	 */
	public Plant findById(Integer plid) ;
}
