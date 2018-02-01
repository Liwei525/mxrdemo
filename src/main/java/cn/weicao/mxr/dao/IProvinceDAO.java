package cn.weicao.mxr.dao;

import cn.weicao.mxr.vo.Province;

public interface IProvinceDAO {
	/**
	 * 根据省份编号查找省份信息
	 * @param pid 省份编号
	 * @return 省份信息
	 */
	public Province findById(Integer pid) ;
}
