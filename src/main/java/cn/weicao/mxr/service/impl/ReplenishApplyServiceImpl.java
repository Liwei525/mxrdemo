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
import cn.weicao.mxr.dao.IReplenishApplyDAO;
import cn.weicao.mxr.dao.IReplenishApplyDetailsDAO;
import cn.weicao.mxr.dao.IUCGoodsDAO;
import cn.weicao.mxr.dao.IWarehouseDAO;
import cn.weicao.mxr.service.IReplenishApplyService;
import cn.weicao.mxr.service.abs.AbstractService;
import cn.weicao.mxr.util.MyMath;
import cn.weicao.mxr.vo.City;
import cn.weicao.mxr.vo.Province;
import cn.weicao.mxr.vo.ReplenishApply;
import cn.weicao.mxr.vo.ReplenishApplyDetails;
import cn.weicao.mxr.vo.UCGoods;
import cn.weicao.mxr.vo.Warehouse;

@Service
public class ReplenishApplyServiceImpl extends AbstractService implements IReplenishApplyService {
	@Resource
	private IWarehouseDAO warehouseDAO ;
	@Resource
	private IProvinceDAO provinceDAO ;
	@Resource
	private IReplenishApplyDAO replenishApplyDAO ;
	@Resource
	private IEmpDAO empDAO ;
	@Resource
	private ICityDAO cityDAO ;
	@Resource(name="redisTemplateReplenish")
	private RedisTemplate<String,Object> redisTemplate ;
	@Resource
	private IUCGoodsDAO ucgoodsDAO ;
	@Resource
	private IReplenishApplyDetailsDAO replenishApplyDetailsDAO ;
	
	@Override
	public List<Province> addPre() {
		List<Province> list = new ArrayList<Province>() ;
		Set<Integer> allPid = this.warehouseDAO.findUcWarehousePid() ;
		Iterator<Integer> iter = allPid.iterator() ;
		while(iter.hasNext()) {
			list.add(this.provinceDAO.findById(iter.next())) ;
		}
		return list;
	}

	@Override
	public boolean add(ReplenishApply replenishApply) {
		return this.replenishApplyDAO.doCreate(replenishApply);
	}
	
	@Override
	public Map<String, Object> list(int currentPage, int lineSize, String column, String keyWord, Date start,
			Date end) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<Integer,Object> allWarehouses = new HashMap<Integer,Object>() ;
		Map<Integer,Object> allMembers = new HashMap<Integer,Object>() ;
		List<ReplenishApply> allReplenishApplys = this.replenishApplyDAO.findSplit(super.converToMap(currentPage, lineSize, column, keyWord, start, end)) ;
		int allRecorders = this.replenishApplyDAO.getCount(super.converToMap(0, 0, column, keyWord, start, end)) ;
		Iterator<ReplenishApply> iter = allReplenishApplys.iterator() ;
		while(iter.hasNext()) {
			ReplenishApply replenishApply = iter.next() ;
			allWarehouses.put(replenishApply.getRaid(), this.warehouseDAO.findById(replenishApply.getWid())) ;
			allMembers.put(replenishApply.getRaid(), this.empDAO.findById(replenishApply.getWatchMid())) ;
		}
		map.put("allReplenishApplys", allReplenishApplys) ;
		map.put("allRecorders", allRecorders) ;
		map.put("allWarehouses", allWarehouses) ;
		map.put("allMembers", allMembers) ;
		return map;
	}
	
	@Override
	public ReplenishApply get(int raid) {
		return this.replenishApplyDAO.findById(raid) ;
	}
	
	@Override
	public Map<String, Object> editPre(int raid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		List<Province> allProvinces = new ArrayList<Province>() ;
		List<City> allCitys = new ArrayList<City>() ;
		List<Warehouse> allWarehouses = new ArrayList<Warehouse>() ;
		ReplenishApply replenishApply = this.replenishApplyDAO.findById(raid) ;
		Set<Integer> allProvincesPid = this.warehouseDAO.findUcWarehousePid() ;
		Iterator<Integer> pidIter = allProvincesPid.iterator() ;
		while(pidIter.hasNext()) {
			allProvinces.add(this.provinceDAO.findById(pidIter.next())) ;
		}
		Set<Integer> allCitysCid = this.warehouseDAO.findUcWarehouseCidByPid(replenishApply.getPid()) ;
		Iterator<Integer> cidIter = allCitysCid.iterator() ;
		while(cidIter.hasNext()) {
			allCitys.add(this.cityDAO.findById(cidIter.next())) ;
		}
		Map<String,Object> param = new HashMap<String,Object>() ;
		param.put("pid", replenishApply.getPid()) ;
		param.put("cid", replenishApply.getCid()) ;
		allWarehouses = this.warehouseDAO.findUcWarehouseByPidAndCid(param) ;
		map.put("replenishApply", replenishApply) ;
		map.put("allProvinces", allProvinces) ;
		map.put("allCitys", allCitys) ;
		map.put("allWarehouses", allWarehouses) ;
		return map ;
	}
	
	@Override
	public boolean edit(ReplenishApply replenishApply) {
		return this.replenishApplyDAO.doEdit(replenishApply) ;
	}
	
	@Override
	public boolean remove(int raid) {
		return this.replenishApplyDAO.doRemove(raid);
	}
	
	@Override
	public Map<String, Object> listDetails(int raid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		List<UCGoods> allUCGoods = new ArrayList<UCGoods>() ;
		Map<Integer,Object> allUCGoodsAmount = new HashMap<Integer,Object>() ;
		ReplenishApply replenishApply = this.replenishApplyDAO.findById(raid) ;
		Warehouse warehouse = this.warehouseDAO.findById(replenishApply.getWid()) ;
		Set<Object> keys = this.redisTemplate.opsForHash().keys(String.valueOf(raid)) ;
		Iterator<Object> iter = keys.iterator() ;
		while(iter.hasNext()) {
			int ucid = Integer.parseInt(String.valueOf(iter.next())) ;
			int amount = (Integer)this.redisTemplate.opsForHash().get(String.valueOf(raid), String.valueOf(ucid)) ;
			allUCGoods.add(this.ucgoodsDAO.findById(ucid)) ;
			allUCGoodsAmount.put(ucid, amount) ;
		}
		map.put("replenishApply", replenishApply) ;
		map.put("warehouse", warehouse) ;
		map.put("allUCGoods", allUCGoods) ;
		map.put("allUCGoodsAmount", allUCGoodsAmount) ;
		return map ;
	}

	@Override
	public boolean addUCGoods(String raid, String ucid, int amount) {
		this.redisTemplate.opsForHash().put(raid, ucid, amount);
		if(this.redisTemplate.opsForHash().get(raid, ucid) != null) {
			return true ;
		}else {
			return false ;
		}
	}

	@Override
	public boolean removeUCGoods(String raid, String ucid) {
		this.redisTemplate.opsForHash().delete(raid, ucid);
		if(this.redisTemplate.opsForHash().get(raid, ucid) == null) {
			return true ;
		}else {
			return false ;
		}
	}

	@Override
	public List<UCGoods> ucgoodsLike(String raid, String keyWord) {
		List<UCGoods> list = new ArrayList<UCGoods>() ;
		Set<Integer> allSaveUcid = new HashSet<Integer>() ;
		List<UCGoods> allUCGoods = this.ucgoodsDAO.findByLike('%' + keyWord + '%') ;
		Set<Object> saveUcid = this.redisTemplate.opsForHash().keys(raid) ;
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
	public boolean submit(ReplenishApply replenishApply) {
		Set<Object> keys = this.redisTemplate.opsForHash().keys(String.valueOf(replenishApply.getRaid())) ;
		if(keys.size() == 0) {
			return false ;
		}
		Iterator<Object> keysIter = keys.iterator() ;
		while(keysIter.hasNext()) {
			String key = (String) keysIter.next() ;
			int amount = (int) this.redisTemplate.opsForHash().get(String.valueOf(replenishApply.getRaid()), key) ;
			UCGoods ucgoods = this.ucgoodsDAO.findById(Integer.parseInt(key)) ;
			ReplenishApplyDetails replenishApplyDetails = new ReplenishApplyDetails() ;
			replenishApplyDetails.setRaid(replenishApply.getRaid());
			replenishApplyDetails.setUcid(ucgoods.getUcid());
			replenishApplyDetails.setName(ucgoods.getName());
			replenishApplyDetails.setSize(ucgoods.getSize());
			replenishApplyDetails.setUnit(ucgoods.getUnit());
			replenishApplyDetails.setPrice(ucgoods.getPrice());;
			replenishApplyDetails.setNum(amount);
			replenishApplyDetails.setTotalPrice(MyMath.round(ucgoods.getPrice() * amount, 2));
			if(!this.replenishApplyDetailsDAO.doCreate(replenishApplyDetails)) {
				return false ;
			}
		}
		if(this.replenishApplyDAO.doEdit(replenishApply)) {
			return true ;
		}else {
			return false ;
		}
	}
}
