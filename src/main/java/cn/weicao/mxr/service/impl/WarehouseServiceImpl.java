package cn.weicao.mxr.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.weicao.mxr.dao.ICityDAO;
import cn.weicao.mxr.dao.IEmpDAO;
import cn.weicao.mxr.dao.IProvinceDAO;
import cn.weicao.mxr.dao.IWarehouseDAO;
import cn.weicao.mxr.dao.IWarehouseUCGoodsDAO;
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
	@Resource
	private IEmpDAO empDAO ;
	@Resource
	private IWarehouseUCGoodsDAO warehouseUCGoodsDAO ;
	
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

	@Override
	public Map<String, Object> addPre() {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("allProvinces", this.provinceDAO.findAll()) ;
		return map;
	}
	
	@Override
	public List<City> getCity(int pid) {
		return this.cityDAO.findAllByPid(pid);
	}
	
	@Override
	public Warehouse get(String name) {
		return this.warehouseDAO.findByName(name);
	}
	
	@Override
	public boolean add(Warehouse warehouse) {
		return this.warehouseDAO.doCreate(warehouse);
	}
	
	@Override
	public Map<String, Object> list(int currentPage, int lineSize, String column, String keyWord) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<Integer,Object> allMembers = new HashMap<Integer,Object>() ;
		List<Warehouse> allWarehouses = this.warehouseDAO.findSplit(super.converToMap(currentPage, lineSize, column, keyWord, null, null)) ;
		int allRecorders = this.warehouseDAO.getCount(super.converToMap(0, 0, column, keyWord, null, null)) ;
		Iterator<Warehouse> iter = allWarehouses.iterator() ;
		while(iter.hasNext()) {
			Warehouse warehouse = iter.next() ;
			allMembers.put(warehouse.getWid(), this.empDAO.findById(warehouse.getRecorder())) ;
		}
		map.put("allWarehouses", allWarehouses) ;
		map.put("allRecorders", allRecorders) ;
		map.put("allMembers", allMembers) ;
		return map;
	}
	
	@Override
	public Map<String,Object> getAllUCGoodsByWid(int wid,int currentPage,int lineSize) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<String,Object> param = new HashMap<String,Object>() ;
		param.put("wid", wid) ;
		param.put("start", (currentPage - 1) * lineSize) ;
		param.put("lineSize", lineSize) ;
		map.put("allWarehouseUCGoods", this.warehouseUCGoodsDAO.findSplitByWid(param)) ;
		map.put("count", this.warehouseUCGoodsDAO.getCountByWid(wid)) ;
		return map ;
	}
	
	@Override
	public Map<String, Object> editPre(int wid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Warehouse warehouse = this.warehouseDAO.findById(wid) ;
		List<Province> allProvinces = this.provinceDAO.findAll() ;
		List<City> allCitys = this.cityDAO.findAllByPid(warehouse.getPid()) ;
		map.put("warehouse", warehouse) ;
		map.put("allProvinces", allProvinces) ;
		map.put("allCitys", allCitys) ;
		return map ;
	}
	
	@Override
	public boolean edit(Warehouse warehouse) {
		return this.warehouseDAO.doEdit(warehouse);
	}
}
