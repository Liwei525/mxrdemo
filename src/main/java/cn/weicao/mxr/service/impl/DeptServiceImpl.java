package cn.weicao.mxr.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.weicao.mxr.dao.IDeptDAO;
import cn.weicao.mxr.service.IDeptService;
import cn.weicao.mxr.service.abs.AbstractService;
import cn.weicao.mxr.vo.Dept;
@Service
public class DeptServiceImpl extends AbstractService implements IDeptService{
	@Resource
	private IDeptDAO deptDAO ;
	@Override
	public Dept get(int did) {
		return this.deptDAO.findById(did);
	}
	
}
