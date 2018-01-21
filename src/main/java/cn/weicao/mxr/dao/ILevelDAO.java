package cn.weicao.mxr.dao;

import java.util.List;

import cn.weicao.mxr.vo.Level;

public interface ILevelDAO {
	/**
	 * 根据等级编号取得等级信息
	 * @param lid 等级编号
	 * @return 等级信息
	 */
	public Level findById(Integer lid) ;
	/**
	 * 查询出不包含总裁的所有雇员职位信息
	 * @return 所有的雇员职位
	 */
	public List<Level> findAllNoMaster() ;
}
