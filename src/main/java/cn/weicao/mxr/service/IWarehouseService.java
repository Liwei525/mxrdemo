package cn.weicao.mxr.service;

import java.util.Map;

public interface IWarehouseService {
	/**
	 * 根据仓库编号查询仓库信息
	 * @param wid 仓库编号
	 * @return 以map形式返回
	 * 1、key = warehouse , value 表示仓库信息
	 * 2、key = province , value 表示省份信息
	 * 3、key = city , value 表示城市信息
	 */
	public Map<String,Object> get(int wid) ;
}
