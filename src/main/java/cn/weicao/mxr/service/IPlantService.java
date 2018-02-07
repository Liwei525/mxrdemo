package cn.weicao.mxr.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.weicao.mxr.vo.City;
import cn.weicao.mxr.vo.Plant;
import cn.weicao.mxr.vo.Province;

public interface IPlantService {
	/**
	 * 根据车间编号查找车间信息
	 * @param plid 车间编号
	 * @return 以map形式返回
	 * 1、key = plant , value 表示车间信息
	 * 2、key = province , value 表示省份信息
	 * 3、key = city , value 表示城市信息
	 */
	public Map<String,Object> get(int plid) ;
	/**
	 * 车间增加前的省份列表
	 * @return 省份列表
	 */
	public List<Province> addPre() ;
	/**
	 * 根据省份编号查找该省份对应的所有城市信息
	 * @param pid 省份编号
	 * @return 该省份对应的所有城市信息
	 */
	public List<City> getCity(int pid) ;
	/**
	 * 根据车间名称查找车间信息
	 * @param name 车间名称
	 * @return 车间信息
	 */
	public Plant get(String name) ;
	/**
	 * 增加车间信息
	 * @param plant 车间信息
	 * @return 增加成功返回true
	 */
	public boolean add(Plant plant) ;
	/**
	 * 分页模糊查询车间
	 * @param currentPage 当前页
	 * @param lineSize 每页的行数
	 * @param column 模糊查询的列
	 * @param keyWord 模糊查询的关键字
	 * @return 以map形式返回
	 * 1、key = allPlants , value 表示所有的车间信息
	 * 2、key = allRecorders , value 表示满足条件车间的数量
	 * 3、key = allMembers , value 表示所有的录入者信息
	 */
	public Map<String,Object> list(int currentPage,int lineSize,String column,String keyWord) ;
	/**
	 * 编辑前的回显操作
	 * @param plid 车间编号
	 * @return 以map形式返回
	 * 1、key = plant , value 表示车间信息
	 * 2、key = allProvinces , value 表示所有的省份信息
	 * 3、key = allCitys , value 表示该省份对应的所有城市信息
	 */
	public Map<String,Object> editPre(int plid) ;
	/**
	 * 修改车间信息
	 * @param plant 车间信息
	 * @return 修改成功返回true
	 */
	public boolean edit(Plant plant) ;
	/**
	 * 删除车间信息
	 * @param plid 车间编号
	 * @return 删除成功返回true
	 */
	public boolean remove(int plid) ;
}
