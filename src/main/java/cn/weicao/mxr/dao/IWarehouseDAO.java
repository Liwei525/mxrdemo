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
}
