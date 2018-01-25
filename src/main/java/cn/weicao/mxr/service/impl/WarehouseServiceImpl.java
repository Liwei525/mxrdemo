package cn.weicao.mxr.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.weicao.mxr.dao.ICityDAO;
import cn.weicao.mxr.dao.IProvinceDAO;
import cn.weicao.mxr.dao.IWarehouseDAO;
import cn.weicao.mxr.service.IWarehouseService;
import cn.weicao.mxr.service.abs.AbstractService;
import cn.weicao.mxr.vo.City;
import cn.weicao.mxr.vo.Province;
import cn.weicao.mxr.vo.Warehouse;
@Service
public class WarehouseServiceImpl extends AbstractService implements IWarehouseService {
	@Resource
	private IWarehouseDAO warehouseDAO ;
	@Resource
	private IProvinceDAO provinceDAO ;
	@Resource
	private ICityDAO cityDAO ;
	
	@Override
	public Map<String, Object> get(int wid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Warehouse warehouse = this.warehouseDAO.findById(wid) ;
		Province province = this.provinceDAO.findById(warehouse.getPid()) ;
		City city = this.cityDAO.findById(warehouse.getCid()) ;
		map.put("warehouse", warehouse) ;
		map.put("province", province) ;
		map.put("city", city) ;
		return map;
	}

}
