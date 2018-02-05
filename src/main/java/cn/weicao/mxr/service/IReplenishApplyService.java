package cn.weicao.mxr.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.weicao.mxr.vo.Province;
import cn.weicao.mxr.vo.ReplenishApply;
import cn.weicao.mxr.vo.UCGoods;

public interface IReplenishApplyService {
	/**
	 * 补货增加前的操作
	 * @return 返回有半成品仓库的省份
	 */
	public List<Province> addPre() ;
	/**
	 * 补货增加
	 * @param replenishApply 补货单信息
	 * @return 增加成功返回true
	 */
	public boolean add(ReplenishApply replenishApply) ;
	/**
	 * 时间分页模糊查询补货单
	 * @param currentPage 当前页
	 * @param lineSize 每页的行数
	 * @param column 模糊查询的列
	 * @param keyWord 模糊查询的关键字
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return 以map形式返回
	 * 1、key = allReplenishApplys , value 表示满足条件的补货单
	 * 2、key = allRecorders , value 表示满足条件的补货单数量
	 * 3、key = allWarehouses , value 表示所有的仓库信息
	 * 4、key = allMembers , value 表示所有的申请人信息
	 */
	public Map<String,Object> list(int currentPage,int lineSize,String column,String keyWord,Date start,Date end) ;
	/**
	 * 根据补货单号查询补货的信息
	 * @param raid 补货单号
	 * @return 补货信息
	 */
	public ReplenishApply get(int raid) ;
	/**
	 * 编辑前的回显操作
	 * @param raid 补货单号
	 * @return 以map形式返回
	 * 1、key = replenishApply , value 表示的是补货单号信息
	 * 2、key = allProvinces , value 表示所有有半成品仓库的省份信息
	 * 3、key = allCitys , value 表示该省份有半成品仓库的城市信息
	 * 4、key = allWarehouses , value 表示该省份和城市有半成品仓库的仓库信息
	 */
	public Map<String,Object> editPre(int raid) ;
	/**
	 * 编辑补货单
	 * @param replenishApply 补货单信息
	 * @return 修改成功返回true
	 */
	public boolean edit(ReplenishApply replenishApply) ;
	/**
	 * 删除补货申请单
	 * @param raid 补货单号
	 * @return 删除成功返回true
	 */
	public boolean remove(int raid) ;
	/**
	 * 补货申请单详细列表
	 * @param raid 补货单号
	 * @return 以map形式返回
	 * 1、key = replenishApply , value 表示补货申请单信息
	 * 2、key = warehouse , value 表示要补货的仓库信息
	 * 3、key = allUCGoods , value 表示所有的半成品信息
	 * 4、key = allUCGoodsAmount , value 表示所有的半成品对应的数量
	 */
	public Map<String,Object> listDetails(int raid) ;
	/**
	 * 增加半成品信息
	 * @param raid 补货单号
	 * @param ucid 半成品编号
	 * @param amount 数量
	 * @return 增加成功返回true
	 */
	public boolean addUCGoods(String raid,String ucid,int amount) ;
	/**
	 * 删除半成品信息
	 * @param raid 补货单号
	 * @param ucid 半成品编号
	 * @return 删除成功返回true
	 */
	public boolean removeUCGoods(String raid,String ucid) ;
	/**
	 * 除了补货申请单添加过的半成品以外的半成品信息
	 * @param raid 补货单号
	 * @param keyWord 模糊查询的关键字
	 * @return 满足条件的所有的半成品信息
	 */
	public List<UCGoods> ucgoodsLike(String raid,String keyWord) ;
	/**
	 * 补货申请单提交操作
	 * @param replenishApply 补货申请单信息
 	 * @return 提交成功返回true
	 */
	public boolean submit(ReplenishApply replenishApply) ;
}
