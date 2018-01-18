package cn.weicao.mxr.service;

import cn.weicao.mxr.vo.Dept;

public interface IDeptService {
	/**
	 * 根据部门编号查找部门信息
	 * @param did 部门编号
	 * @return 部门信息
	 */
	public Dept get(int did) ;
}
