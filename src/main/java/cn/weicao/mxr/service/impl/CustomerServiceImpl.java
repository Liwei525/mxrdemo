package cn.weicao.mxr.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.weicao.mxr.dao.ICitemDAO;
import cn.weicao.mxr.dao.ICityDAO;
import cn.weicao.mxr.dao.ICustomerDAO;
import cn.weicao.mxr.dao.IEmpDAO;
import cn.weicao.mxr.dao.IProvinceDAO;
import cn.weicao.mxr.service.ICustomerService;
import cn.weicao.mxr.service.abs.AbstractService;
import cn.weicao.mxr.vo.Citem;
import cn.weicao.mxr.vo.City;
import cn.weicao.mxr.vo.Customer;
import cn.weicao.mxr.vo.Emp;
import cn.weicao.mxr.vo.Province;

@Service
public class CustomerServiceImpl extends AbstractService implements ICustomerService{
	@Resource
	private IProvinceDAO provinceDAO ;
	@Resource
	private ICitemDAO citemDAO ;
	@Resource
	private ICityDAO cityDAO ;
	@Resource
	private ICustomerDAO customerDAO ;
	@Resource
	private IEmpDAO empDAO ;
	
	@Override
	public Map<String, Object> addPre() {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("allCitems", this.citemDAO.findAll()) ;
		map.put("allProvinces", this.provinceDAO.findAll()) ;
		return map ; 
	}
	
	@Override
	public List<City> getCity(int pid) {
		return this.cityDAO.findAllByPid(pid) ;
	}

	@Override
	public Customer get(int ctid) {
		return this.customerDAO.findById(ctid) ;
	}

	@Override
	public Customer get(String name) {
		return this.customerDAO.findByName(name) ;
	}
	
	@Override
	public boolean add(Customer customer) {
		return this.customerDAO.doCreate(customer) ;
	}

	@Override
	public Map<String, Object> list(int currentPage, int lineSize, String column, String keyWord) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<Integer,Object> allCitems = new HashMap<Integer,Object>() ;
		List<Customer> allCustomers = this.customerDAO.findSplit(super.converToMap(currentPage, lineSize, column, keyWord, null, null)) ;
		Iterator<Customer> iter = allCustomers.iterator() ;
		while(iter.hasNext()) {
			Customer customer = iter.next() ;
			allCitems.put(customer.getCtid(), this.citemDAO.findById(customer.getCiid())) ;
		}
		map.put("allCustomers", allCustomers) ;
		map.put("allRecorders", this.customerDAO.getCount(super.converToMap(0, 0, column, keyWord, null, null))) ;
		map.put("allCitems", allCitems) ;
		return map;
	}
	
	@Override
	public Map<String, Object> editPre(int ctid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Customer customer = this.customerDAO.findById(ctid) ;
		List<Citem> allCitems = this.citemDAO.findAll() ;
		List<Province> allProvinces = this.provinceDAO.findAll() ;
		List<City> allCitys = this.cityDAO.findAllByPid(customer.getPid()) ;
		map.put("customer", customer) ;
		map.put("allCitems", allCitems) ;
		map.put("allProvinces", allProvinces) ;
		map.put("allCitys", allCitys) ;
		return map ;
	}
	
	@Override
	public boolean edit(Customer customer) {
		return this.customerDAO.doEdit(customer);
	}
	
	@Override
	public boolean remove(int ctid) {
		return this.customerDAO.doRemove(ctid) ;
	}
	
	@Override
	public Map<String, Object> listDetails(int ctid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Customer customer = this.customerDAO.findById(ctid) ;
		Citem citem = this.citemDAO.findById(customer.getCiid()) ;
		Emp recorder = this.empDAO.findById(customer.getRecorder()) ;
		map.put("customer", customer) ;
		map.put("citem", citem) ;
		map.put("recorder", recorder) ;
		return map ;
	}
}
