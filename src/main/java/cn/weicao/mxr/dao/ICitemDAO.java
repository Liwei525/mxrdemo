package cn.weicao.mxr.dao;

import java.util.List;

import cn.weicao.mxr.vo.Citem;

public interface ICitemDAO {
	/**
	 * 查找所有的客户等级记录
	 * @return 所有的客户等级
	 */
	public List<Citem> findAll() ;
	/**
	 * 根据客户等级编号查找客户等级信息
	 * @param ciid 客户等级编号
	 * @return 客户等级信息
	 */
	public Citem findById(Integer ciid) ;
}
