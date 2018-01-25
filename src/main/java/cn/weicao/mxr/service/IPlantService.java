package cn.weicao.mxr.service;

import java.util.Map;

public interface IPlantService {
	/**
	 * 根据车间编号查找车间信息
	 * @param plid 车间编号
	 * @return 以map形式返回
	 * 1、key = plant , value 表示车间信息
	 * 2、key = province , value 表示省份信息
	 * 3、key = city , value 表示城市信息
	 */
	public Map<String,Object> get(int plid) ;
}
