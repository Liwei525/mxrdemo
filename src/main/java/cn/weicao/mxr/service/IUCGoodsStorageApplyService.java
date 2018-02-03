package cn.weicao.mxr.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.weicao.mxr.vo.City;
import cn.weicao.mxr.vo.Province;
import cn.weicao.mxr.vo.UCGoods;
import cn.weicao.mxr.vo.UCGoodsStorageApply;
import cn.weicao.mxr.vo.Warehouse;

public interface IUCGoodsStorageApplyService {
	/**
	 * 入库申请单创建前的仓库选择限制
	 * @return 返回所有半成品仓库所在的省份信息
	 */
	public List<Province> addPre() ;
	/**
	 * 根据省份编号查找有半成品仓库的城市信息
	 * @param pid 省份编号
	 * @return 城市信息
	 */
	public List<City> getCity(int pid) ;
	/**
	 * 根据省份编号和城市编号找到满足条件的半成品仓库信息
	 * @param pid 省份编号
	 * @param cid 城市编号
	 * @return 满足条件的半成品仓库信息
	 */
	public List<Warehouse> getWarehouse(int pid,int cid) ;
	/**
	 * 根据合同号取得入库申请单信息
	 * @param usaid 合同号
	 * @return 入库申请单信息
	 */
	public UCGoodsStorageApply get(String usaid) ;
	/**
	 * 增加入库申请单
	 * @param ucgoodsStorageApply 入库申请单信息
	 * @return 增加成功返回true
	 */
	public boolean add(UCGoodsStorageApply ucgoodsStorageApply) ;
	/**
	 * 入库申请单列表显示
	 * @param currentPage 当前页
	 * @param lineSize 每页的行数
	 * @param column 模糊查询的列
	 * @param keyWord 模糊查询的关键字
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return 以map形式返回
	 * 1、key = allUCGoodsStorageApplys , value 表示所有的入库申请单信息
	 * 1、key = allRecorders , value 表示入库申请单数量
	 * 2、key = allUCWarehouses , value 表示所有的入库申请单的入库仓库信息
	 */
	public Map<String,Object> list(int currentPage,int lineSize,String column,String keyWord,Date start,Date end) ;
	/**
	 * 编辑前的回显操作
	 * @param usaid 合同号
	 * @return 以map形式返回
	 * 1、key = ucgoodsStorageApply , value 表示的是入库申请单信息
	 * 2、key = allProvinces , value 表示所有有半成品仓库的省份信息
	 * 3、key = allCitys , value 表示该省份有半成品仓库的城市信息
	 * 4、key = allUCWarehouses , value 表示该省份和城市有半成品仓库的仓库信息
	 */
	public Map<String,Object> editPre(String usaid) ;
	/**
	 * 修改入库申请单
	 * @param ucgoodsStorageApply 合同号
	 * @return 修改成功返回true 
	 */
	public boolean edit(UCGoodsStorageApply ucgoodsStorageApply) ;
	/**
	 * 入库申请单详细列表
	 * @param usaid 合同号
	 * @return 以map形式返回
	 * 1、key = ucgoodsStorageApply , value 表示入库申请单信息
	 * 2、key = warehouse , value 表示要入库的仓库信息
	 * 3、key = allUCGoods , value 表示所有的半成品信息
	 * 4、key = allUCGoodsAmount , value 表示所有的半成品对应的数量
	 */
	public Map<String,Object> listDetails(String usaid) ;
	/**
	 * 增加半成品信息
	 * @param usaid 合同号
	 * @param ucid 半成品编号
	 * @param amount 数量
	 * @return 增加成功返回true
	 */
	public boolean addUCGoods(String usaid,String ucid,int amount) ;
	/**
	 * 删除半成品信息
	 * @param usaid 合同号
	 * @param ucid 半成品编号
	 * @return 删除成功返回true
	 */
	public boolean removeUCGoods(String usaid,String ucid) ;
	/**
	 * 除了入库申请单添加过的半成品以外的半成品信息
	 * @param usaid 合同号
	 * @param keyWord 模糊查询的关键字
	 * @return 满足条件的所有的半成品信息
	 */
	public List<UCGoods> ucgoodsLike(String usaid,String keyWord) ;
	/**
	 * 入库申请单提交操作
	 * @param ucgoodsStorageApply 入库申请单信息
 	 * @return 提交成功返回true
	 */
	public boolean submit(UCGoodsStorageApply ucgoodsStorageApply) ;
	/**
	 * 删除入库申请单
	 * @param usaid 合同号
	 * @return 删除成功返回true
	 */
	public boolean remove(String usaid) ;
	/**
	 * 根据合同号，查询各个点的操作人和时间
	 * @param usaid 合同号
	 * @return 以map形式返回
	 * 1、key = ucgoodsStorageApply , value 表示入库申请单
	 * 2、key = appMember , value 表示申请人的姓名
	 * 3、key = sendMember , value 表示发送人的姓名
	 * 4、key = auditMember , value 表示审核人的姓名
	 * 5、key = storageMember , value 表示最后一次入库人的姓名
	 */
	public Map<String,Object> trail(String usaid) ;
	/**
	 * 根据合同号查询出所有的入库申请单号
	 * @param usaid 合同号
	 * @return 以map形式返回
	 * 1、key = ucgoodsStorageApply , value 表示入库申请单信息
	 * 2、key = warehouse , value 表示要入的仓库信息
	 * 2、key = allUsawid , value 表示所有的入库申请单编号
	 */
	public Map<String,Object> usawidShow(String usaid) ;
	/**
	 * 入库单号对应的详细信息
	 * @param usawid 入库单号
	 * @param jsCommonCp 当前页
	 * @param jsCommonLs 每页的行数
	 * @return 以map形式返回
	 * 1、key = ucgoodsStorageApplyWarehouse , value 表示该入库单号对应的信息
	 * 2、key = inMember , value 表示入库人的信息
	 * 3、key = allUCGoodsStorageApplyRecord , value 表示该入库单号对应的半成品信息（分页）
	 * 4、key = count ,value 表示该入库单号对应的半成品种类的数据量
	 */
	public Map<String,Object> usawidDetails(String usawid,int jsCommonCp,int jsCommonLs) ;
}
