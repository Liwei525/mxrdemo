package cn.weicao.mxr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.weicao.mxr.dao.IUCGoodsDAO;
import cn.weicao.mxr.dao.IUCGoodsStorageApplyDAO;
import cn.weicao.mxr.dao.IUCGoodsStorageApplyDetailsDAO;
import cn.weicao.mxr.dao.IUCGoodsStorageApplyRecordDAO;
import cn.weicao.mxr.dao.IUCGoodsStorageApplyWarehouseDAO;
import cn.weicao.mxr.dao.IWarehouseDAO;
import cn.weicao.mxr.dao.IWarehouseUCGoodsDAO;
import cn.weicao.mxr.service.IUCGoodsManageService;
import cn.weicao.mxr.service.abs.AbstractService;
import cn.weicao.mxr.vo.UCGoods;
import cn.weicao.mxr.vo.UCGoodsStorageApply;
import cn.weicao.mxr.vo.UCGoodsStorageApplyDetails;
import cn.weicao.mxr.vo.UCGoodsStorageApplyRecord;
import cn.weicao.mxr.vo.UCGoodsStorageApplyWarehouse;
import cn.weicao.mxr.vo.Warehouse;
import cn.weicao.mxr.vo.WarehouseUCGoods;

@Service
public class UCGoodsManageServiceImpl extends AbstractService implements IUCGoodsManageService{
	@Resource
	private IUCGoodsStorageApplyDAO ucgoodsStorageApplyDAO ;
	@Resource
	private IWarehouseDAO warehouseDAO ;
	@Resource
	private IUCGoodsStorageApplyWarehouseDAO ucgoodsStorageApplyWarehouseDAO ;
	@Resource
	private IUCGoodsStorageApplyDetailsDAO ucgoodsStorageApplyDetailsDAO ;
	@Resource
	private IUCGoodsStorageApplyRecordDAO ucgoodsStorageApplyRecordDAO ;
	@Resource
	private IUCGoodsDAO ucgoodsDAO ;
	@Resource
	private IWarehouseUCGoodsDAO warehouseUCGoodsDAO ;
	
	@Override
	public List<UCGoodsStorageApply> usaidLike(String keyWord) {
		return this.ucgoodsStorageApplyDAO.usaidLikeByStatus3AndStatus4("%" + keyWord + "%") ;
	}
	
	@Override
	public Map<String, Object> storageDetails(String usaid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		List<UCGoodsStorageApplyDetails> restUcgoods = new ArrayList<UCGoodsStorageApplyDetails>() ;
		UCGoodsStorageApply ucgoodsStorageApply = this.ucgoodsStorageApplyDAO.findById(usaid) ;
		Warehouse warehouse = this.warehouseDAO.findById(ucgoodsStorageApply.getWid()) ;
		List<String> allUsawid = this.ucgoodsStorageApplyWarehouseDAO.findByUsaid(usaid) ;
		if(ucgoodsStorageApply.getStatus() == 4) {
			restUcgoods = null;
		}else {
			if(allUsawid.size() == 0) {
				restUcgoods = this.ucgoodsStorageApplyDetailsDAO.findByUsaid(usaid);
			}else {
				restUcgoods = this.restUcgoods(usaid) ;
			}
		}
		map.put("ucgoodsStorageApply", ucgoodsStorageApply) ;
		map.put("warehouse", warehouse) ;
		map.put("allUsawid", allUsawid) ;
		map.put("restUcgoods", restUcgoods) ;
		return map;
	}
	
	@Override
	public boolean usawidSave(String usaid, String usawid, String note, String mid) {
		UCGoodsStorageApply ucgoodsStorageApply = this.ucgoodsStorageApplyDAO.findById(usaid) ;
		ucgoodsStorageApply.setStorageDate(new Date());
		ucgoodsStorageApply.setStorageMid(mid);
		if(this.ucgoodsStorageApplyDAO.doEdit(ucgoodsStorageApply)) {
			UCGoodsStorageApplyWarehouse ucgoodsStorageApplyWarehouse = new UCGoodsStorageApplyWarehouse() ;
			ucgoodsStorageApplyWarehouse.setUsawid(usawid);
			ucgoodsStorageApplyWarehouse.setUsaid(usaid);
			ucgoodsStorageApplyWarehouse.setDate(new Date());
			ucgoodsStorageApplyWarehouse.setInmid(mid);
			ucgoodsStorageApplyWarehouse.setNote(note);
			return this.ucgoodsStorageApplyWarehouseDAO.doCreate(ucgoodsStorageApplyWarehouse) ;
		}
		return false;
	}
	
	@Override
	public boolean ucidSave(String usaid, String usawid, int ucid, int num) {
		UCGoodsStorageApply ucgoodsStorageApply = this.ucgoodsStorageApplyDAO.findById(usaid) ;
		UCGoods ucgoods = this.ucgoodsDAO.findById(ucid) ;
		ucgoods.setStornum(ucgoods.getStornum() + num);
		ucgoods.setLastin(new Date());
		if(this.ucgoodsDAO.doEdit(ucgoods)) {
			Map<String,Object> param = new HashMap<String,Object>() ;
			param.put("usaid", usaid) ;
			param.put("ucid", ucid) ;
			UCGoodsStorageApplyDetails storageDetails = this.ucgoodsStorageApplyDetailsDAO.findByUsaidAndUcid(param) ;
			UCGoodsStorageApplyRecord storageRecord = new UCGoodsStorageApplyRecord() ;
			storageRecord.setUsawid(usawid);
			storageRecord.setUcid(ucid);
			storageRecord.setWid(ucgoodsStorageApply.getWid());
			storageRecord.setName(storageDetails.getName());
			storageRecord.setSize(storageDetails.getSize());
			storageRecord.setPrice(storageDetails.getPrice());
			storageRecord.setUnit(storageDetails.getUnit());
			storageRecord.setNum(num);
			storageRecord.setTotalPrice(storageRecord.getPrice() * storageRecord.getNum());
			storageRecord.setDate(new Date());
			if(this.ucgoodsStorageApplyRecordDAO.doCreate(storageRecord)) {
				Map<String,Object> widAndUcid = new HashMap<String,Object>() ;
				widAndUcid.put("wid", ucgoodsStorageApply.getWid()) ;
				widAndUcid.put("ucid", ucid) ;
				WarehouseUCGoods warehouseUCGoods = this.warehouseUCGoodsDAO.findByWidAndUcid(widAndUcid) ;
				WarehouseUCGoods whu = null ;
				if(warehouseUCGoods == null) {
					whu = new WarehouseUCGoods() ;
					whu.setWid(ucgoodsStorageApply.getWid());
					whu.setUcid(ucid);
					whu.setName(ucgoods.getName());
					whu.setSize(ucgoods.getSize());
					whu.setUnit(ucgoods.getUnit());
					whu.setNum(num);
					if(this.warehouseUCGoodsDAO.doCreate(whu)) {
						if(this.restUcgoods(usaid).size() == 0) {
							ucgoodsStorageApply.setStatus(4);
							return this.ucgoodsStorageApplyDAO.doEdit(ucgoodsStorageApply) ;
						}else {
							return true ;
						}
					}
				}else {
					whu = warehouseUCGoods ;
					whu.setNum(whu.getNum() + num);
					if(this.warehouseUCGoodsDAO.doEdit(whu)) {
						if(this.restUcgoods(usaid).size() == 0) {
							ucgoodsStorageApply.setStatus(4);
							return this.ucgoodsStorageApplyDAO.doEdit(ucgoodsStorageApply) ;
						}else {
							return true ;
						}
					}
				}
			}
		}
		return false ;
	}
	
	private List<UCGoodsStorageApplyDetails> restUcgoods(String usaid){
		List<UCGoodsStorageApplyDetails> restUcgoods = new ArrayList<UCGoodsStorageApplyDetails>() ;
		List<String> allUsawid = this.ucgoodsStorageApplyWarehouseDAO.findByUsaid(usaid) ;
		Map<Integer,Integer> record = new HashMap<Integer,Integer>() ;
		Iterator<String> usawidIter = allUsawid.iterator() ;
		while(usawidIter.hasNext()) {
			List<UCGoodsStorageApplyRecord> allUCGoodsStorageApplyRecord = this.ucgoodsStorageApplyRecordDAO.findByUsawid(usawidIter.next()) ;
			Iterator<UCGoodsStorageApplyRecord> ucgoodsStorageApplyRecordIter = allUCGoodsStorageApplyRecord.iterator() ;
			while(ucgoodsStorageApplyRecordIter.hasNext()) {
				UCGoodsStorageApplyRecord ucgoodsStorageApplyRecord = ucgoodsStorageApplyRecordIter.next() ;
				if(record.containsKey(ucgoodsStorageApplyRecord.getUcid())) {
					record.put(ucgoodsStorageApplyRecord.getUcid(), record.get(ucgoodsStorageApplyRecord.getUcid()) + ucgoodsStorageApplyRecord.getNum()) ;
				}else {
					record.put(ucgoodsStorageApplyRecord.getUcid(), ucgoodsStorageApplyRecord.getNum()) ;
				}
			}
		}
		List<UCGoodsStorageApplyDetails> allUCGoodsStorageApplyDetails = this.ucgoodsStorageApplyDetailsDAO.findByUsaid(usaid) ;
		Iterator<UCGoodsStorageApplyDetails> ucgoodsStorageApplyDetailsIter = allUCGoodsStorageApplyDetails.iterator() ;
		while(ucgoodsStorageApplyDetailsIter.hasNext()) {
			UCGoodsStorageApplyDetails ucgoodsStorageApplyDetails = ucgoodsStorageApplyDetailsIter.next() ;
			if(record.containsKey(ucgoodsStorageApplyDetails.getUcid())) {
				if(record.get(ucgoodsStorageApplyDetails.getUcid()) < ucgoodsStorageApplyDetails.getNum()) {
					ucgoodsStorageApplyDetails.setNum(ucgoodsStorageApplyDetails.getNum() - record.get(ucgoodsStorageApplyDetails.getUcid()));;
					ucgoodsStorageApplyDetails.setTotalPrice(ucgoodsStorageApplyDetails.getPrice() * ucgoodsStorageApplyDetails.getNum()) ;
					restUcgoods.add(ucgoodsStorageApplyDetails) ;
				}
			}else {
				restUcgoods.add(ucgoodsStorageApplyDetails) ;
			}
		}
		return restUcgoods ;
	}
}
