package cn.weicao.mxr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.weicao.mxr.dao.IEmpDAO;
import cn.weicao.mxr.dao.IReplenishApplyDAO;
import cn.weicao.mxr.dao.IReplenishApplyDetailsDAO;
import cn.weicao.mxr.dao.IWarehouseDAO;
import cn.weicao.mxr.service.IWarehouseReplenishService;
import cn.weicao.mxr.service.abs.AbstractService;
import cn.weicao.mxr.util.MyMath;
import cn.weicao.mxr.vo.Emp;
import cn.weicao.mxr.vo.ReplenishApply;
import cn.weicao.mxr.vo.ReplenishApplyDetails;
import cn.weicao.mxr.vo.Warehouse;

@Service
public class WarehouseReplenishServiceImpl extends AbstractService implements IWarehouseReplenishService{
	@Resource
	private IReplenishApplyDAO replenishApplyDAO ;
	@Resource
	private IReplenishApplyDetailsDAO replenishApplyDetailsDAO ;
	@Resource
	private IWarehouseDAO warehouseDAO ;
	@Resource
	private IEmpDAO empDAO ;
	
	@Override
	public Map<String, Object> list(int currentPage, int lineSize, String column, String keyWord, Date start,
			Date end) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<Integer,Object> allWarehouses = new HashMap<Integer,Object>() ;
		Map<Integer,Object> allSendMembers = new HashMap<Integer,Object>() ;
		Map<String,Object> param = super.converToMap(currentPage, lineSize, column, keyWord, start, end) ;
		Map<String,Object> param2 = super.converToMap(0, 0, column, keyWord, start, end) ;
		List<Integer> list = new ArrayList<Integer>() ;
		list.add(1) ;
		list.add(2) ;
		param.put("allStatus", list) ;
		param2.put("allStatus", list) ;
		List<ReplenishApply> allReplenishApply = this.replenishApplyDAO.findSplitByStatus(param) ;
		int allRecorders = this.replenishApplyDAO.getCountByStatus(param2) ;
		Iterator<ReplenishApply> iter = allReplenishApply.iterator() ;
		while(iter.hasNext()) {
			ReplenishApply replenishApply = iter.next() ;
			allWarehouses.put(replenishApply.getRaid(), this.warehouseDAO.findById(replenishApply.getWid())) ;
			allSendMembers.put(replenishApply.getRaid(), this.empDAO.findById(replenishApply.getSendMid())) ;
		}
		map.put("allReplenishApply", allReplenishApply) ;
		map.put("allRecorders", allRecorders) ;
		map.put("allWarehouses", allWarehouses) ;
		map.put("allSendMembers", allSendMembers) ;
		return map;
	}
	
	@Override
	public Map<String, Object> listDetails(int raid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		ReplenishApply replenishApply = this.replenishApplyDAO.findById(raid) ;
		Warehouse warehouse = this.warehouseDAO.findById(replenishApply.getWid()) ;
		Emp sendMember = this.empDAO.findById(replenishApply.getSendMid()) ;
		Emp watchMember = this.empDAO.findById(replenishApply.getWatchMid()) ;
		List<ReplenishApplyDetails> allReplenishApplyDetails = this.replenishApplyDetailsDAO.findByRaid(raid) ;
		double totalPrice = 0 ;
		Iterator<ReplenishApplyDetails> replenishApplyDetailsIter = allReplenishApplyDetails.iterator() ;
		while(replenishApplyDetailsIter.hasNext()) {
			totalPrice += replenishApplyDetailsIter.next().getTotalPrice() ;
		}
		map.put("replenishApply", replenishApply) ;
		map.put("warehouse", warehouse) ;
		map.put("totalPrice", MyMath.round(totalPrice,2)) ;
		map.put("sendMember", sendMember) ;
		map.put("watchMember", watchMember) ;
		map.put("allReplenishApplyDetails", allReplenishApplyDetails) ;
		return map;
	}
	
	@Override
	public boolean submit(ReplenishApply replenishApply) {
		return this.replenishApplyDAO.doEdit(replenishApply);
	}
	
}
