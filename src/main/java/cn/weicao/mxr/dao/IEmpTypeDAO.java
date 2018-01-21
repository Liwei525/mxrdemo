package cn.weicao.mxr.dao;

import java.util.List;

import cn.weicao.mxr.vo.EmpType;

public interface IEmpTypeDAO {
	/**
	 * 根据工种编号取得工种信息
	 * @param etid 工种编号
	 * @return 工种信息
	 */
	public EmpType findById(Integer etid) ;
	/**
	 * 查询出所有的工种信息
	 * @return 所有的工种信息
	 */
	public List<EmpType> findAll() ;
}
