package cn.weicao.mxr.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.weicao.mxr.dao.ICityDAO;
import cn.weicao.mxr.dao.IEmpDAO;
import cn.weicao.mxr.dao.IPlantDAO;
import cn.weicao.mxr.dao.IProvinceDAO;
import cn.weicao.mxr.dao.IUCGoodsDAO;
import cn.weicao.mxr.dao.IUCGoodsOutputRecordDAO;
import cn.weicao.mxr.dao.IUCGoodsStorageApplyRecordDAO;
import cn.weicao.mxr.dao.IWarehouseDAO;
import cn.weicao.mxr.dao.IWarehouseUCGoodsDAO;
import cn.weicao.mxr.service.IUCGoodsService;
import cn.weicao.mxr.service.abs.AbstractService;
import cn.weicao.mxr.vo.UCGoods;
import cn.weicao.mxr.vo.UCGoodsOutputRecord;
import cn.weicao.mxr.vo.UCGoodsStorageApplyRecord;
import cn.weicao.mxr.vo.Warehouse;
import cn.weicao.mxr.vo.WarehouseUCGoods;
@Service
public class UCGoodsServiceImpl extends AbstractService implements IUCGoodsService {
	@Resource
	private IUCGoodsDAO ucgoodsDAO ;
	@Resource
	private IEmpDAO empDAO ;
	@Resource
	private IUCGoodsStorageApplyRecordDAO ucgoodsStorageApplyRecordDAO ;
	@Resource
	private IUCGoodsOutputRecordDAO ucgoodsOutputRecordDAO ;
	@Resource
	private IWarehouseDAO warehouseDAO ;
	@Resource
	private IPlantDAO plantDAO ;
	@Resource
	private IWarehouseUCGoodsDAO warehouseUCGoodsDAO ;
	@Resource
	private IProvinceDAO provinceDAO ;
	@Resource
	private ICityDAO cityDAO ;
	@Override
	public UCGoods getByName(String name) {
		return ucgoodsDAO.findByName(name);
	}
	
	@Override
	public boolean add(UCGoods ucgoods) {
		if(this.getByName(ucgoods.getName()) == null) {
			return this.ucgoodsDAO.doCreate(ucgoods) ;
		}else {
			return false ;
		}
	}

	@Override
	public Map<String,Object> list(int currentPage, int lineSize, String column, String keyWord, Date start, Date end) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<Integer,Object> allMembers = new HashMap<Integer,Object>() ;
		List<UCGoods> allUCGoods = this.ucgoodsDAO.findSplit(super.converToMap(currentPage, lineSize, column, keyWord, start, end)) ;
		int allRecorders = this.ucgoodsDAO.getCount(super.converToMap(0, 0, column, keyWord, start, end)) ;
		Iterator<UCGoods> iter = allUCGoods.iterator() ;
		while(iter.hasNext()) {
			UCGoods ucgoods = iter.next() ;
			allMembers.put(ucgoods.getUcid(), this.empDAO.findById(ucgoods.getRecorder())) ;
		}
		map.put("allUCGoods", allUCGoods) ;
		map.put("allRecorders",allRecorders) ;
		map.put("allMembers",allMembers) ;
		return map ;
	}

	@Override
	public UCGoods get(int ucid) {
		return this.ucgoodsDAO.findById(ucid) ;
	}

	@Override
	public boolean edit(UCGoods ucgoods) {
		UCGoods olducgoods = this.ucgoodsDAO.findById(ucgoods.getUcid()) ;
		if(olducgoods.getName().equals(ucgoods.getName()) || this.ucgoodsDAO.findByName(ucgoods.getName()) == null) {
			return this.ucgoodsDAO.doEdit(ucgoods) ;
		}else {
			return false ;
		}
	}

	@Override
	public Map<String, Object> show(int ucid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("ucgoods", this.ucgoodsDAO.findById(ucid)) ;
		map.put("storageCount", this.ucgoodsStorageApplyRecordDAO.findByUcid(ucid).size()) ;
		map.put("outputCount", this.ucgoodsOutputRecordDAO.findByUcid(ucid).size()) ;
		return map;
	}

	@Override
	public Map<String, Object> showStorageDetails(int ucid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<Integer,Object> allWarehouse = new HashMap<Integer,Object>() ;
		List<UCGoodsStorageApplyRecord> allUCGoodsStorageApplyRecord = this.ucgoodsStorageApplyRecordDAO.findByUcid(ucid) ;
		Iterator<UCGoodsStorageApplyRecord> iter = allUCGoodsStorageApplyRecord.iterator() ;
		while(iter.hasNext()) {
			UCGoodsStorageApplyRecord ucgoodsStorageApplyRecord = iter.next() ;
			allWarehouse.put(ucgoodsStorageApplyRecord.getUsarid(), this.warehouseDAO.findById(ucgoodsStorageApplyRecord.getWid())) ;
		}
		map.put("allUCGoodsStorageApplyRecord", allUCGoodsStorageApplyRecord) ;
		map.put("allWarehouse", allWarehouse) ;
		return map;
	}
	
	@Override
	public Map<String, Object> showOutputDetails(int ucid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<Integer,Object> allWarehouse = new HashMap<Integer,Object>() ;
		Map<Integer,Object> allPlant = new HashMap<Integer,Object>() ;
		List<UCGoodsOutputRecord> allUCGoodsOutputRecord = this.ucgoodsOutputRecordDAO.findByUcid(ucid) ;
		Iterator<UCGoodsOutputRecord> iter = allUCGoodsOutputRecord.iterator() ;
		while(iter.hasNext()) {
			UCGoodsOutputRecord ucgoodsOutputRecord = iter.next() ;
			allWarehouse.put(ucgoodsOutputRecord.getUorid(), this.warehouseDAO.findById(ucgoodsOutputRecord.getWid())) ;
			allPlant.put(ucgoodsOutputRecord.getUorid(), this.plantDAO.findById(ucgoodsOutputRecord.getPlid())) ;
		}
		map.put("allUCGoodsOutputRecord", allUCGoodsOutputRecord) ;
		map.put("allWarehouse", allWarehouse) ;
		map.put("allPlant", allPlant) ;
		return map;
	}
	
	@Override
	public Map<String, Object> ucgoodsNumDetails(int ucid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<Integer,Object> allWarehouse = new HashMap<Integer,Object>() ;
		Map<Integer,Object> allProvince = new HashMap<Integer,Object>() ;
		Map<Integer,Object> allCity = new HashMap<Integer,Object>() ;
		List<WarehouseUCGoods> allWarehouseUCGoods = this.warehouseUCGoodsDAO.findByUcid(ucid) ;
		Iterator<WarehouseUCGoods> iter = allWarehouseUCGoods.iterator() ;
		while(iter.hasNext()) {
			WarehouseUCGoods warehouseUCGoods = iter.next() ;
			Warehouse warehouse = this.warehouseDAO.findById(warehouseUCGoods.getWid()) ;
			allProvince.put(warehouse.getWid(), this.provinceDAO.findById(warehouse.getPid())) ;
			allCity.put(warehouse.getWid(), this.cityDAO.findById(warehouse.getCid())) ;
			allWarehouse.put(warehouseUCGoods.getWuid(), warehouse) ;
		}
		map.put("allWarehouseUCGoods", allWarehouseUCGoods) ;
		map.put("allWarehouse", allWarehouse) ;
		map.put("allProvince", allProvince) ;
		map.put("allCity", allCity) ;
		return map ;
	}
}
