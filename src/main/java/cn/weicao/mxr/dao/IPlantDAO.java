package cn.weicao.mxr.dao;

import java.util.List;
import java.util.Map;

import cn.weicao.mxr.vo.Plant;

public interface IPlantDAO {
	/**
	 * 根据车间编号查询车间信息
	 * @param plid 车间编号
	 * @return 车间信息
	 */
	public Plant findById(Integer plid) ;
	/**
	 * 根据车间名称查询车间信息
	 * @param name 车间名称
	 * @return 车间信息
	 */
	public Plant findByName(String name) ;
	/**
	 * 增加车间
	 * @param plant 车间信息
	 * @return 增加成功返回true
	 */
	public boolean doCreate(Plant plant) ;
	/**
	 * 分页模糊查询
	 * @param param 里面有分页模糊参数
	 * @return 返回满足条件的车间
	 */
	public List<Plant> findSplit(Map<String,Object> param) ;
	/**
	 * 模糊查询的数量
	 * @param param 里面有模糊参数
	 * @return 返回车间数量
	 */
	public Integer getCount(Map<String,Object> param) ;
	/**
	 * 修改车间信息
	 * @param plant 车间信息 
	 * @return 修改成功返回true
	 */
	public boolean doEdit(Plant plant) ;
	/**
	 * 删除车间信息
	 * @param plid 车间编号
	 * @return 删除成功返回true
	 */
	public boolean doRemove(Integer plid) ;
}
