package cn.weicao.mxr.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.weicao.mxr.dao.ICityDAO;
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

}
