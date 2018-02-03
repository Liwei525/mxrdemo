package cn.weicao.mxr.service;

import java.util.Date;
import java.util.Map;

public interface IUCGoodsStorageAuditService {
	/**
	 * 日期时间分页查询
	 * @param currentPage 当前页
	 * @param lineSize 每页的行数
	 * @param column 模糊查询的列
	 * @param keyWord 模糊查询的关键字
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return 以map形式返回
	 * 1、key = allUCGoodsStorageApply , value 表示所有的入库申请单
	 * 2、key = allRecorders , value 表示入库申请单的数量
	 * 3、key = allUCWarehouse , value 表示所有的仓库信息
	 * 4、key = allSendMember , value 表示所有的发送人信息
	 * 5、key = allTotalPrice , value 表示该入库申请单的进货总价
	 */
	public Map<String,Object> listPrepare(int currentPage,int lineSize,String column,String keyWord,Date start,Date end) ; 
	/**
	 * 入库申请单详细信息
	 * @param usaid 合同号
	 * @param currentPage 当前页
	 * @param lineSize 每页的行数
	 * @return 以map形式返回
	 * 1、key = ucgoodsStorageApply , value 表示入库申请单信息
	 * 2、key = warehouse , value 表示要入库的仓库
	 * 3、key = totalPrice , value 表示入库半成品总价
	 * 4、key = allUCGoodsStorageApplyDetails , value 表示入库的半成品分页列表
	 * 5、key = count , value 表示入库半成品种类的数量
	 */
	public Map<String,Object> applyDetails(String usaid,int currentPage,int lineSize) ;
	/**
	 * 入库审核前的显示操作
	 * @param usaid 合同号
	 * @return 以map形式返回
	 * 1、key = ucgoodsStorageApply , value 表示入库申请单信息
	 * 2、key = warehouse , value 表示要入库的仓库
	 * 3、key = sendMember , value 表示发送人的信息
	 * 4、key = totalPrice , value 表示入库半成品总价
	 * 5、key = allUCGoodsStorageApplyDetails , value 表示入库的半成品列表
	 */
	public Map<String,Object> editPre(String usaid) ;
	/**
	 * 审核
	 * @param usaid 合同号
	 * @param audit 是否同意
	 * @param note 备注
	 * @param auditMid 操作人
	 * @return 审核成功返回true,不同意要删除details中对应的数据
	 */
	public boolean edit(String usaid,int audit,String note,String auditMid) ;
	/**
	 * 日期时间分页查询
	 * @param currentPage 当前页
	 * @param lineSize 每页的行数
	 * @param column 模糊查询的列
	 * @param keyWord 模糊查询的关键字
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return 以map形式返回
	 * 1、key = allUCGoodsStorageApply , value 表示所有的入库申请单
	 * 2、key = allRecorders , value 表示入库申请单的数量
	 * 3、key = allUCWarehouse , value 表示所有的仓库信息
	 * 4、key = allSendMember , value 表示所有的发送人信息
	 * 5、key = allTotalPrice , value 表示该入库申请单的进货总价
	 * 6、key = allAuditMember , value 表示所有的审核人信息
	 */
	public Map<String,Object> listHistory(int currentPage,int lineSize,String column,String keyWord,Date start,Date end) ; 
}
