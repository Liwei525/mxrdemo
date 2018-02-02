package cn.weicao.mxr.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.weicao.mxr.dao.IUCGoodsStorageApplyWarehouseDAO;
import cn.weicao.mxr.service.IUCGoodsStorageApplyWarehouseService;
import cn.weicao.mxr.service.abs.AbstractService;
import cn.weicao.mxr.vo.UCGoodsStorageApplyWarehouse;

@Service
public class UCGoodsStorageApplyWarehouseServiceImpl extends AbstractService implements IUCGoodsStorageApplyWarehouseService{
	@Resource
	private IUCGoodsStorageApplyWarehouseDAO ucgoodsStorageApplyWarehouseDAO ;
	
	@Override
	public UCGoodsStorageApplyWarehouse get(String usawid) {
		return this.ucgoodsStorageApplyWarehouseDAO.findById(usawid) ;
	}

}
