package cn.weicao.mxr.service.impl;

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
import cn.weicao.mxr.service.IPlantService;
import cn.weicao.mxr.service.abs.AbstractService;
import cn.weicao.mxr.vo.City;
import cn.weicao.mxr.vo.Plant;
import cn.weicao.mxr.vo.Province;
@Service
public class PlantServiceImpl extends AbstractService implements IPlantService{
	@Resource
	private IPlantDAO plantDAO ;
	@Resource
	private IProvinceDAO provinceDAO ;
	@Resource
	private ICityDAO cityDAO ;
	@Resource
	private IEmpDAO empDAO ;
	
	@Override
	public Map<String, Object> get(int plid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Plant plant = this.plantDAO.findById(plid) ;
		Province province = this.provinceDAO.findById(plant.getPid()) ;
		City city = this.cityDAO.findById(plant.getCid()) ;
		map.put("plant", plant) ;
		map.put("province", province) ;
		map.put("city", city) ;
		return map;
	}

	@Override
	public List<Province> addPre() {
		return this.provinceDAO.findAll() ;
	}
	
	@Override
	public List<City> getCity(int pid) {
		return this.cityDAO.findAllByPid(pid) ;
	}
	
	@Override
	public Plant get(String name) {
		return this.plantDAO.findByName(name) ;
	}
	
	@Override
	public boolean add(Plant plant) {
		return this.plantDAO.doCreate(plant) ;
	}
	
	@Override
	public Map<String, Object> list(int currentPage, int lineSize, String column, String keyWord) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Map<Integer,Object> allMembers = new HashMap<Integer,Object>() ;
		List<Plant> allPlants = this.plantDAO.findSplit(super.converToMap(currentPage, lineSize, column, keyWord, null, null)) ;
		Iterator<Plant> iter = allPlants.iterator() ;
		while(iter.hasNext()) {
			Plant plant = iter.next() ;
			allMembers.put(plant.getPlid(), this.empDAO.findById(plant.getRecorder())) ;
		}
		map.put("allPlants", allPlants) ;
		map.put("allRecorders", this.plantDAO.getCount(super.converToMap(0, 0, column, keyWord, null, null))) ;
		map.put("allMembers", allMembers) ;
		return map ;
	}
	
	@Override
	public Map<String, Object> editPre(int plid) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Plant plant = this.plantDAO.findById(plid) ;
		List<Province> allProvinces = this.provinceDAO.findAll() ;
		List<City> allCitys = this.cityDAO.findAllByPid(plant.getPid()) ;
		map.put("plant", plant) ;
		map.put("allProvinces", allProvinces) ;
		map.put("allCitys", allCitys) ;
		return map ;
	}
	
	@Override
	public boolean edit(Plant plant) {
		return this.plantDAO.doEdit(plant) ;
	}
	
	@Override
	public boolean remove(int plid) {
		return this.plantDAO.doRemove(plid);
	}
}
