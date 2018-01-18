package cn.weicao.mxr.dao;

import cn.weicao.mxr.vo.Level;

public interface ILevelDAO {
	/**
	 * 根据等级编号取得等级信息
	 * @param lid 等级编号
	 * @return 等级信息
	 */
	public Level findById(Integer lid) ;
}
