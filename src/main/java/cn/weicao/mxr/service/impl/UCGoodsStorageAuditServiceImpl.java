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
import cn.weicao.mxr.dao.IUCGoodsStorageApplyDAO;
import cn.weicao.mxr.dao.IUCGoodsStorageApplyDetailsDAO;
import cn.weicao.mxr.dao.IWarehouseDAO;
import cn.weicao.mxr.service.IUCGoodsStorageAuditService;
import cn.weicao.mxr.service.abs.AbstractService;
import cn.weicao.mxr.util.MyMath;
import cn.weicao.mxr.vo.Emp;
import cn.weicao.mxr.vo.UCGoodsStorageApply;
import cn.weicao.mxr.vo.UCGoodsStorageApplyDetails;
import cn.weicao.mxr.vo.Warehouse;
@Service
public class UCGoodsStorageAuditServiceImpl extends AbstractService implements IUCGoodsStorageAuditService{
	@Resource
	private IUCGoodsStorageApplyDAO ucgoodsStorageApplyDAO ;
	@Resource
	private IUCGoodsStorageApplyDetailsDAO ucgoodsStorageApplyDetailsDAO ;
	@Resource
	private IWarehouseDAO warehouseDAO ;
	@Resource
	private IEmpDAO empDAO ;
	
	@Override
	public Map<String, Object> listPrepare(int currentPage, int lineSize, String column, String keyWord, Date start,
			Date end) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<String,Object> allUCWarehouse = new HashMap<String,Object>() ;
		Map<String,Object> allSendMember = new HashMap<String,Object>() ;
		Map<String,Object> allTotalPrice = new HashMap<String,Object>() ;
		Map<String,Object> param = super.converToMap(currentPage, lineSize, column, keyWord, start, end) ;
		Map<String,Object> param2 = super.converToMap(0, 0, column, keyWord, start, end) ;
		List<Integer> list = new ArrayList<Integer>() ;
		list.add(3) ;
		param.put("allStatus", list) ;
		param2.put("allStatus", list) ;
		List<UCGoodsStorageApply> allUCGoodsStorageApply = this.ucgoodsStorageApplyDAO.findSplitByStatus(param) ;
		int allRecorders = this.ucgoodsStorageApplyDAO.getCountByStatus(param2) ;
		Iterator<UCGoodsStorageApply> iter = allUCGoodsStorageApply.iterator() ;
		while(iter.hasNext()) {
			UCGoodsStorageApply ucgoodsStorageApply = iter.next() ;
			allUCWarehouse.put(ucgoodsStorageApply.getUsaid(), this.warehouseDAO.findById(ucgoodsStorageApply.getWid())) ;
			allSendMember.put(ucgoodsStorageApply.getUsaid(), this.empDAO.findById(ucgoodsStorageApply.getSendMid())) ;
			List<UCGoodsStorageApplyDetails> allUCGoodsStorageApplyDetails = this.ucgoodsStorageApplyDetailsDAO.findByUsaid(ucgoodsStorageApply.getUsaid()) ;
			double totalPrice = 0 ;
			Iterator<UCGoodsStorageApplyDetails> ucgoodsStorageApplyDetailsIter = allUCGoodsStorageApplyDetails.iterator() ;
			while(ucgoodsStorageApplyDetailsIter.hasNext()) {
				totalPrice += ucgoodsStorageApplyDetailsIter.next().getTotalPrice() ;
			}
			allTotalPrice.put(ucgoodsStorageApply.getUsaid(), MyMath.round(totalPrice,2)) ;
		}
		map.put("allUCGoodsStorageApply", allUCGoodsStorageApply) ;
		map.put("allRecorders", allRecorders) ;
		map.put("allUCWarehouse", allUCWarehouse) ;
		map.put("allSendMember", allSendMember) ;
		map.put("allTotalPrice", allTotalPrice) ;
		return map;
	}
	
	@Override
	public Map<String, Object> applyDetails(String usaid, int currentPage, int lineSize) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<String,Object> param = new HashMap<String,Object>() ;
		param.put("start", (currentPage-1) * lineSize) ;
		param.put("lineSize", lineSize) ;
		param.put("usaid", usaid) ;
		UCGoodsStorageApply ucgoodsStorageApply = this.ucgoodsStorageApplyDAO.findById(usaid) ;
		Warehouse warehouse = this.warehouseDAO.findById(ucgoodsStorageApply.getWid()) ;
		List<UCGoodsStorageApplyDetails> allUCGoodsStorageApplyDetails = this.ucgoodsStorageApplyDetailsDAO.findByUsaid(ucgoodsStorageApply.getUsaid()) ;
		double totalPrice = 0 ;
		Iterator<UCGoodsStorageApplyDetails> ucgoodsStorageApplyDetailsIter = allUCGoodsStorageApplyDetails.iterator() ;
		while(ucgoodsStorageApplyDetailsIter.hasNext()) {
			totalPrice += ucgoodsStorageApplyDetailsIter.next().getTotalPrice() ;
		}
		map.put("ucgoodsStorageApply", ucgoodsStorageApply) ;
		map.put("warehouse", warehouse) ;
		map.put("totalPrice", MyMath.round(totalPrice,2)) ;
		map.put("allUCGoodsStorageApplyDetails", this.ucgoodsStorageApplyDetailsDAO.findSplitByUsaid(param)) ;
		map.put("count", this.ucgoodsStorageApplyDetailsDAO.getCountByUsaid(usaid)) ;
		return map;
	}
	
	@Override
	public Map<String, Object> editPre(String usaid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		UCGoodsStorageApply ucgoodsStorageApply = this.ucgoodsStorageApplyDAO.findById(usaid) ;
		Warehouse warehouse = this.warehouseDAO.findById(ucgoodsStorageApply.getWid()) ;
		Emp sendMember = this.empDAO.findById(ucgoodsStorageApply.getSendMid()) ;
		List<UCGoodsStorageApplyDetails> allUCGoodsStorageApplyDetails = this.ucgoodsStorageApplyDetailsDAO.findByUsaid(ucgoodsStorageApply.getUsaid()) ;
		double totalPrice = 0 ;
		Iterator<UCGoodsStorageApplyDetails> ucgoodsStorageApplyDetailsIter = allUCGoodsStorageApplyDetails.iterator() ;
		while(ucgoodsStorageApplyDetailsIter.hasNext()) {
			totalPrice += ucgoodsStorageApplyDetailsIter.next().getTotalPrice() ;
		}
		map.put("ucgoodsStorageApply", ucgoodsStorageApply) ;
		map.put("warehouse", warehouse) ;
		map.put("totalPrice", MyMath.round(totalPrice,2)) ;
		map.put("sendMember", sendMember) ;
		map.put("allUCGoodsStorageApplyDetails", this.ucgoodsStorageApplyDetailsDAO.findByUsaid(usaid)) ;
		return map;
	}
	
	@Override
	public boolean edit(String usaid, int audit, String note, String auditMid) {
		if(audit == 1) { //同意
			UCGoodsStorageApply ucgoodsStorageApply = this.ucgoodsStorageApplyDAO.findById(usaid) ;
			ucgoodsStorageApply.setAuditMid(auditMid);
			if(ucgoodsStorageApply.getAuditNote() == null) {
				ucgoodsStorageApply.setAuditNote(note);
			}else {
				ucgoodsStorageApply.setAuditNote(ucgoodsStorageApply.getAuditNote() + "\r\n\r\n" + note);
			}
			ucgoodsStorageApply.setAuditDate(new Date());
			ucgoodsStorageApply.setStatus(3);
			return this.ucgoodsStorageApplyDAO.doEdit(ucgoodsStorageApply) ;
		}else { //不同意
			UCGoodsStorageApply ucgoodsStorageApply = this.ucgoodsStorageApplyDAO.findById(usaid) ;
			ucgoodsStorageApply.setAuditMid(auditMid);
			if(ucgoodsStorageApply.getAuditNote() == null) {
				ucgoodsStorageApply.setAuditNote(note);
			}else {
				ucgoodsStorageApply.setAuditNote(ucgoodsStorageApply.getAuditNote() + "\r\n\r\n" + note);
			}
			ucgoodsStorageApply.setAuditDate(new Date());
			ucgoodsStorageApply.setStatus(2);
			if(this.ucgoodsStorageApplyDAO.doEdit(ucgoodsStorageApply)) {
				return this.ucgoodsStorageApplyDetailsDAO.doRemove(usaid) ;
			}else {
				return false ;
			}
		}
	}
	
	@Override
	public Map<String, Object> listHistory(int currentPage, int lineSize, String column, String keyWord, Date start,
			Date end) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<String,Object> allUCWarehouse = new HashMap<String,Object>() ;
		Map<String,Object> allSendMember = new HashMap<String,Object>() ;
		Map<String,Object> allTotalPrice = new HashMap<String,Object>() ;
		Map<String,Object> allAuditMember = new HashMap<String,Object>() ;
		Map<String,Object> param = super.converToMap(currentPage, lineSize, column, keyWord, start, end) ;
		Map<String,Object> param2 = super.converToMap(0, 0, column, keyWord, start, end) ;
		List<Integer> list = new ArrayList<Integer>() ;
		list.add(3) ;
		list.add(4) ;
		param.put("allStatus", list) ;
		param2.put("allStatus", list) ;
		List<UCGoodsStorageApply> allUCGoodsStorageApply = this.ucgoodsStorageApplyDAO.findSplitByStatus(param) ;
		int allRecorders = this.ucgoodsStorageApplyDAO.getCountByStatus(param2) ;
		Iterator<UCGoodsStorageApply> iter = allUCGoodsStorageApply.iterator() ;
		while(iter.hasNext()) {
			UCGoodsStorageApply ucgoodsStorageApply = iter.next() ;
			allUCWarehouse.put(ucgoodsStorageApply.getUsaid(), this.warehouseDAO.findById(ucgoodsStorageApply.getWid())) ;
			allSendMember.put(ucgoodsStorageApply.getUsaid(), this.empDAO.findById(ucgoodsStorageApply.getSendMid())) ;
			List<UCGoodsStorageApplyDetails> allUCGoodsStorageApplyDetails = this.ucgoodsStorageApplyDetailsDAO.findByUsaid(ucgoodsStorageApply.getUsaid()) ;
			double totalPrice = 0 ;
			Iterator<UCGoodsStorageApplyDetails> ucgoodsStorageApplyDetailsIter = allUCGoodsStorageApplyDetails.iterator() ;
			while(ucgoodsStorageApplyDetailsIter.hasNext()) {
				totalPrice += ucgoodsStorageApplyDetailsIter.next().getTotalPrice() ;
			}
			allTotalPrice.put(ucgoodsStorageApply.getUsaid(), MyMath.round(totalPrice,2)) ;
			allAuditMember.put(ucgoodsStorageApply.getUsaid(), this.empDAO.findById(ucgoodsStorageApply.getAuditMid())) ;
		}
		map.put("allUCGoodsStorageApply", allUCGoodsStorageApply) ;
		map.put("allRecorders", allRecorders) ;
		map.put("allUCWarehouse", allUCWarehouse) ;
		map.put("allSendMember", allSendMember) ;
		map.put("allTotalPrice", allTotalPrice) ;
		map.put("allAuditMember", allAuditMember) ;
		return map;
	}
}
