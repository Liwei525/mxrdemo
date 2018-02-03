package cn.weicao.mxr.dao;

import java.util.List;

import cn.weicao.mxr.vo.City;

public interface ICityDAO {
	/**
	 * 根据城市编号查询城市信息
	 * @param cid 城市编号
	 * @return 城市信息
	 */
	public City findById(Integer cid) ;
	/**
	 * 根据省份编号查询所有的城市信息
	 * @param pid 省份编号
	 * @return 该省份对应的所有的城市
	 */
	public List<City> findAllByPid(Integer pid) ;
}
