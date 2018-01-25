package cn.weicao.mxr.dao;

import cn.weicao.mxr.vo.Warehouse;

public interface IWarehouseDAO {
	/**
	 * 根据仓库编号查找仓库信息
	 * @param wid 仓库编号
	 * @return 仓库信息
	 */
	public Warehouse findById(Integer wid) ;
}
