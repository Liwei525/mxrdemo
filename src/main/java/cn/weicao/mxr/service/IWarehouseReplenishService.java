package cn.weicao.mxr.service;

import java.util.Date;
import java.util.Map;

import cn.weicao.mxr.vo.ReplenishApply;

public interface IWarehouseReplenishService {
	/**
	 * 时间分页模糊查询补货申请单
	 * @param currentPage 当前页
	 * @param lineSize 每页的行数
	 * @param column 模糊查询的列
	 * @param keyWord 模糊查询的关键字
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return 以map形式返回
	 * 1、key = allReplenishApply , value 表示所有的补货申请单
	 * 2、key = allRecorders , value 表示补货申请单的数量
	 * 3、key = allWarehouse , value 表示所有的仓库信息
	 * 4、key = allSendMember , value 表示所有的发送人信息
	 */
	public Map<String,Object> list(int currentPage, int lineSize, String column, String keyWord, Date start,Date end) ;
	/**
	 * 补货申请单详细列表
	 * @param raid 补货单号
	 * @return 以map形式返回
	 * 1、key = replenishApply , value 补货单信息
	 * 2、key = warehouse , value 表示仓库信息
	 * 3、key = sendMember , value 表示发送人信息
	 * 3、key = watchMember , value 表示查看人信息
	 * 4、key = totalPrice , value 表示总价
	 * 5、key = allReplenishApplyDetails , value 表示所有的半成品信息
	 */
	public Map<String,Object> listDetails(int raid) ;
	/**
	 * 提交补货申请单
	 * @param replenishApply 补货申请单信息
	 * @return 提交成功返回true
	 */
	public boolean submit(ReplenishApply replenishApply) ;
}
