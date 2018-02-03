package cn.weicao.mxr.dao;

import java.util.List;
import java.util.Map;

import cn.weicao.mxr.vo.Warehouse;

public interface IWarehouseDAO {
	/**
	 * 根据仓库编号查找仓库信息
	 * @param wid 仓库编号
	 * @return 仓库信息
	 */
	public Warehouse findById(Integer wid) ;
	/**
	 * 查找所有的半成品仓库的省份id
	 * @return 省份id
	 */
	public List<Integer> findUcWarehousePid() ;
	/**
	 * 根据省份信息查找有半成品仓库的城市编号
	 * @param pid 省份信息
	 * @return 城市编号
	 */
	public List<Integer> findUcWarehouseCidByPid(Integer pid) ;
	/**
	 * 根据省份编号和城市编号查找满足条件的半成品仓库编号
	 * @param map 里面有省份编号和城市编号
	 * @return 满足条件的半成品仓库编号
	 */
	public List<Warehouse> findUcWarehouseByPidAndCid(Map<String,Object> map) ;
	/**
	 * 根据仓库名称查询仓库信息
	 * @param name 仓库名称
	 * @return 仓库信息
	 */
	public Warehouse findByName(String name) ;
	/**
	 * 增加仓库
	 * @param warehouse 仓库的信息
	 * @return 增加成功返回true
	 */
	public boolean doCreate(Warehouse warehouse) ;
	/**
	 * 分页模糊查询
	 * @param map 里面有分页模糊查询参数
	 * @return 返回满足条件的仓库信息
	 */
	public List<Warehouse> findSplit(Map<String,Object> map) ;
	/**
	 * 模糊查询的数据量
	 * @param map 里面有模糊查询参数
	 * @return 返回数据量
	 */
	public Integer getCount(Map<String,Object> map) ;
	/**
	 * 修改仓库
	 * @param warehouse 仓库的信息
	 * @return 修改成功返回true
	 */
	public boolean doEdit(Warehouse warehouse) ;
}
