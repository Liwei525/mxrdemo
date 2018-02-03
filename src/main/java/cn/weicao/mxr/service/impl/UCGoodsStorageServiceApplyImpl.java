package cn.weicao.mxr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import cn.weicao.mxr.dao.ICityDAO;
import cn.weicao.mxr.dao.IEmpDAO;
import cn.weicao.mxr.dao.IProvinceDAO;
import cn.weicao.mxr.dao.IUCGoodsDAO;
import cn.weicao.mxr.dao.IUCGoodsStorageApplyDAO;
import cn.weicao.mxr.dao.IUCGoodsStorageApplyDetailsDAO;
import cn.weicao.mxr.dao.IUCGoodsStorageApplyRecordDAO;
import cn.weicao.mxr.dao.IUCGoodsStorageApplyWarehouseDAO;
import cn.weicao.mxr.dao.IWarehouseDAO;
import cn.weicao.mxr.service.IUCGoodsStorageApplyService;
import cn.weicao.mxr.service.abs.AbstractService;
import cn.weicao.mxr.util.MyMath;
import cn.weicao.mxr.vo.City;
import cn.weicao.mxr.vo.Emp;
import cn.weicao.mxr.vo.Province;
import cn.weicao.mxr.vo.UCGoods;
import cn.weicao.mxr.vo.UCGoodsStorageApply;
import cn.weicao.mxr.vo.UCGoodsStorageApplyDetails;
import cn.weicao.mxr.vo.UCGoodsStorageApplyWarehouse;
import cn.weicao.mxr.vo.Warehouse;
@Service
public class UCGoodsStorageServiceApplyImpl extends AbstractService implements IUCGoodsStorageApplyService {
	@Resource
	private RedisTemplate<String, Object> redisTemplate ;
	@Resource
	private IUCGoodsStorageApplyDAO ucgoodsStorageApplyDAO ; 
	@Resource
	private IUCGoodsDAO ucgoodsDAO ;
	@Resource
	private IWarehouseDAO warehouseDAO ;
	@Resource
	private IProvinceDAO provinceDAO ;
	@Resource
	private ICityDAO cityDAO ;
	@Resource
	private IUCGoodsStorageApplyDetailsDAO ucgoodsStorageApplyDetailsDAO ;
	@Resource
	private IEmpDAO empDAO ;
	@Resource
	private IUCGoodsStorageApplyWarehouseDAO ucgoodsStorageApplyWarehouseDAO ;
	@Resource
	private IUCGoodsStorageApplyRecordDAO ucgoodsStorageApplyRecordDAO ;
	@Override
	public List<Province> addPre() {
		List<Province> list = new ArrayList<Province>() ;
		List<Integer> allPid = this.warehouseDAO.findUcWarehousePid() ;
		Iterator<Integer> iter = allPid.iterator() ;
		while(iter.hasNext()) {
			list.add(this.provinceDAO.findById(iter.next())) ;
		}
		return list;
	}
	
	@Override
	public List<City> getCity(int pid) {
		List<City> list = new ArrayList<City>() ;
		List<Integer> allCid = this.warehouseDAO.findUcWarehouseCidByPid(pid) ;
		Iterator<Integer> iter = allCid.iterator() ;
		while(iter.hasNext()) {
			list.add(this.cityDAO.findById(iter.next())) ;
		}
		return list;
	}
	
	@Override
	public List<Warehouse> getWarehouse(int pid, int cid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("pid", pid) ;
		map.put("cid", cid) ;
		return this.warehouseDAO.findUcWarehouseByPidAndCid(map) ;
	}
	
	@Override
	public UCGoodsStorageApply get(String usaid) {
		return this.ucgoodsStorageApplyDAO.findById(usaid) ;
	}
	
	@Override
	public boolean add(UCGoodsStorageApply ucgoodsStorageApply) {
		if(this.get(ucgoodsStorageApply.getUsaid()) == null) {
			return this.ucgoodsStorageApplyDAO.doCreate(ucgoodsStorageApply) ;
		}
		return false;
	}
	
	@Override
	public Map<String, Object> list(int currentPage, int lineSize, String column, String keyWord, Date start,
			Date end) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<String,Object> allUCWarehouses = new HashMap<String,Object>() ;
		List<UCGoodsStorageApply> list = this.ucgoodsStorageApplyDAO.findSplit(super.converToMap(currentPage, lineSize, column, keyWord, start, end)) ;
		int allRecorders = this.ucgoodsStorageApplyDAO.getCount(super.converToMap(0, 0, column, keyWord, start, end)) ;
		Iterator<UCGoodsStorageApply> iter = list.iterator() ;
		while(iter.hasNext()) {
			UCGoodsStorageApply ucgoodsStorageApply = iter.next() ;
			allUCWarehouses.put(ucgoodsStorageApply.getUsaid(), this.warehouseDAO.findById(ucgoodsStorageApply.getWid())) ;
		}
		map.put("allUCGoodsStorageApplys", list) ;
		map.put("allRecorders", allRecorders) ;
		map.put("allUCWarehouses", allUCWarehouses) ;
		return map ;
	}
	
	@Override
	public Map<String, Object> editPre(String usaid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		List<Province> allProvinces = new ArrayList<Province>() ;
		List<City> allCitys = new ArrayList<City>() ;
		List<Warehouse> allUCWarehouses = new ArrayList<Warehouse>() ;
		UCGoodsStorageApply ucgoodsStorageApply = this.ucgoodsStorageApplyDAO.findById(usaid) ;
		List<Integer> allProvincesPid = this.warehouseDAO.findUcWarehousePid() ;
		Iterator<Integer> pidIter = allProvincesPid.iterator() ;
		while(pidIter.hasNext()) {
			allProvinces.add(this.provinceDAO.findById(pidIter.next())) ;
		}
		List<Integer> allCitysCid = this.warehouseDAO.findUcWarehouseCidByPid(ucgoodsStorageApply.getPid()) ;
		Iterator<Integer> cidIter = allCitysCid.iterator() ;
		while(cidIter.hasNext()) {
			allCitys.add(this.cityDAO.findById(cidIter.next())) ;
		}
		Map<String,Object> param = new HashMap<String,Object>() ;
		param.put("pid", ucgoodsStorageApply.getPid()) ;
		param.put("cid", ucgoodsStorageApply.getCid()) ;
		allUCWarehouses = this.warehouseDAO.findUcWarehouseByPidAndCid(param) ;
		map.put("ucgoodsStorageApply", ucgoodsStorageApply) ;
		map.put("allProvinces", allProvinces) ;
		map.put("allCitys", allCitys) ;
		map.put("allUCWarehouses", allUCWarehouses) ;
		return map ;
	}
	
	@Override
	public boolean edit(UCGoodsStorageApply ucgoodsStorageApply) {
		return this.ucgoodsStorageApplyDAO.doEdit(ucgoodsStorageApply);
	}
	
	@Override
	public Map<String, Object> listDetails(String usaid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		List<UCGoods> allUCGoods = new ArrayList<UCGoods>() ;
		Map<Integer,Object> allUCGoodsAmount = new HashMap<Integer,Object>() ;
		UCGoodsStorageApply ucgoodsStorageApply = this.ucgoodsStorageApplyDAO.findById(usaid) ;
		Warehouse warehouse = this.warehouseDAO.findById(ucgoodsStorageApply.getWid()) ;
		Set<Object> keys = this.redisTemplate.opsForHash().keys(usaid) ;
		Iterator<Object> iter = keys.iterator() ;
		while(iter.hasNext()) {
			int ucid = Integer.parseInt(String.valueOf(iter.next())) ;
			int amount = (Integer)this.redisTemplate.opsForHash().get(usaid, String.valueOf(ucid)) ;
			allUCGoods.add(this.ucgoodsDAO.findById(ucid)) ;
			allUCGoodsAmount.put(ucid, amount) ;
		}
		map.put("ucgoodsStorageApply", ucgoodsStorageApply) ;
		map.put("warehouse", warehouse) ;
		map.put("allUCGoods", allUCGoods) ;
		map.put("allUCGoodsAmount", allUCGoodsAmount) ;
		return map ;
	}
	
	@Override
	public boolean addUCGoods(String usaid, String ucid, int amount) {
		this.redisTemplate.opsForHash().put(usaid, ucid, amount);
		if(this.redisTemplate.opsForHash().get(usaid, ucid) != null) {
			return true ;
		}else {
			return false ;
		}
	}
	
	@Override
	public boolean removeUCGoods(String usaid, String ucid) {
		this.redisTemplate.opsForHash().delete(usaid, ucid);
		if(this.redisTemplate.opsForHash().get(usaid, ucid) == null) {
			return true ;
		}else {
			return false ;
		}
	}
	
	@Override
	public List<UCGoods> ucgoodsLike(String usaid,String keyWord) {
		List<UCGoods> list = new ArrayList<UCGoods>() ;
		Set<Integer> allSaveUcid = new HashSet<Integer>() ;
		List<UCGoods> allUCGoods = this.ucgoodsDAO.findByLike('%' + keyWord + '%') ;
		Set<Object> saveUcid = this.redisTemplate.opsForHash().keys(usaid) ;
		Iterator<Object> ucidIter = saveUcid.iterator() ;
		while(ucidIter.hasNext()) {
			allSaveUcid.add(Integer.parseInt(String.valueOf(ucidIter.next()))) ;
		}
		Iterator<UCGoods> iter = allUCGoods.iterator() ;
		while(iter.hasNext()) {
			UCGoods ucgoods = iter.next() ;
			if(!allSaveUcid.contains(ucgoods.getUcid())) {
				list.add(ucgoods);
			}
		}
		return list;
	}
	
	@Override
	public boolean submit(UCGoodsStorageApply ucgoodsStorageApply) { 
		Set<Object> keys = this.redisTemplate.opsForHash().keys(ucgoodsStorageApply.getUsaid()) ;
		if(keys.size() == 0) {
			return false ;
		}
		Iterator<Object> keysIter = keys.iterator() ;
		while(keysIter.hasNext()) {
			String key = (String) keysIter.next() ;
			int amount = (int) this.redisTemplate.opsForHash().get(ucgoodsStorageApply.getUsaid(), key) ;
			UCGoods ucgoods = this.ucgoodsDAO.findById(Integer.parseInt(key)) ;
			UCGoodsStorageApplyDetails ucgoodsStorageApplyDetails = new UCGoodsStorageApplyDetails() ;
			ucgoodsStorageApplyDetails.setUsaid(ucgoodsStorageApply.getUsaid());
			ucgoodsStorageApplyDetails.setUcid(ucgoods.getUcid());
			ucgoodsStorageApplyDetails.setName(ucgoods.getName());
			ucgoodsStorageApplyDetails.setSize(ucgoods.getSize());
			ucgoodsStorageApplyDetails.setUnit(ucgoods.getUnit());
			ucgoodsStorageApplyDetails.setPrice(ucgoods.getPrice());;
			ucgoodsStorageApplyDetails.setNum(amount);
			ucgoodsStorageApplyDetails.setTotalPrice(MyMath.round(ucgoods.getPrice() * amount, 2));
			if(!this.ucgoodsStorageApplyDetailsDAO.doCreate(ucgoodsStorageApplyDetails)) {
				return false ;
			}
		}
		if(this.ucgoodsStorageApplyDAO.doEdit(ucgoodsStorageApply)) {
			return true ;
		}else {
			return false ;
		}
	}
	
	@Override
	public boolean remove(String usaid) {
		Set<Object> keys = this.redisTemplate.opsForHash().keys(usaid) ;
		Iterator<Object> keysIter = keys.iterator() ;
		while(keysIter.hasNext()) {
			String key = (String) keysIter.next() ;
			if(this.redisTemplate.opsForHash().delete(usaid, key) != 1) {
				return false ;
			}
		}
		return this.ucgoodsStorageApplyDAO.doRemove(usaid);
	}
	
	@Override
	public Map<String, Object> trail(String usaid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		UCGoodsStorageApply ucgoodsStorageApply = this.ucgoodsStorageApplyDAO.findById(usaid) ;
		map.put("ucgoodsStorageApply", ucgoodsStorageApply) ;
		map.put("appMember", this.empDAO.findById(ucgoodsStorageApply.getAppMid())) ;
		map.put("sendMember", this.empDAO.findById(ucgoodsStorageApply.getSendMid())) ;
		map.put("auditMember", this.empDAO.findById(ucgoodsStorageApply.getAuditMid())) ;
		map.put("storageMember", this.empDAO.findById(ucgoodsStorageApply.getStorageMid())) ;
		return map;
	}

	@Override
	public Map<String, Object> usawidShow(String usaid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		UCGoodsStorageApply ucgoodsStorageApply = this.ucgoodsStorageApplyDAO.findById(usaid) ;
		map.put("ucgoodsStorageApply", ucgoodsStorageApply ) ;
		map.put("warehouse", this.warehouseDAO.findById(ucgoodsStorageApply.getWid()) ) ;
		map.put("allUsawid", this.ucgoodsStorageApplyWarehouseDAO.findByUsaid(usaid)) ;
		return map;
	}
	
	@Override
	public Map<String, Object> usawidDetails(String usawid, int jsCommonCp, int jsCommonLs) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<String,Object> param = new HashMap<String,Object>() ;
		param.put("usawid", usawid) ;
		param.put("start", (jsCommonCp - 1) * jsCommonLs) ;
		param.put("lineSize", jsCommonLs) ;
		UCGoodsStorageApplyWarehouse ucgoodsStorageApplyWarehouse = this.ucgoodsStorageApplyWarehouseDAO.findById(usawid) ;
		Emp inMember = this.empDAO.findById(ucgoodsStorageApplyWarehouse.getInmid()) ;
		map.put("ucgoodsStorageApplyWarehouse", ucgoodsStorageApplyWarehouse) ;
		map.put("inMember", inMember) ;
		map.put("allUCGoodsStorageApplyRecord", this.ucgoodsStorageApplyRecordDAO.findSplitByUsawid(param)) ;
		map.put("count", this.ucgoodsStorageApplyRecordDAO.getCountByUsawid(usawid)) ;
		return map;
	}
}
