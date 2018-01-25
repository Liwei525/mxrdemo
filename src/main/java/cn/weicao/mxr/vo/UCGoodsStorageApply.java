package cn.weicao.mxr.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class UCGoodsStorageApply implements Serializable{
	private String usaid ;
	private String title ;
	private Integer pid ;
	private Integer cid ;
	private Integer wid ;
	private String note ;
	private Integer status ;
	private String appMid ;
	private Date appDate ;
	private String sendMid ;
	private Date sendDate ;
	private String auditMid ;
	private Date auditDate ;
	private String auditNote ;
	private Integer flag ; //1代表未删除，0代表已删除
	public String getUsaid() {
		return usaid;
	}
	public void setUsaid(String usaid) {
		this.usaid = usaid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getAppMid() {
		return appMid;
	}
	public void setAppMid(String appMid) {
		this.appMid = appMid;
	}
	public Date getAppDate() {
		return appDate;
	}
	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}
	public String getSendMid() {
		return sendMid;
	}
	public void setSendMid(String sendMid) {
		this.sendMid = sendMid;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getAuditMid() {
		return auditMid;
	}
	public void setAuditMid(String auditMid) {
		this.auditMid = auditMid;
	}
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	public String getAuditNote() {
		return auditNote;
	}
	public void setAuditNote(String auditNote) {
		this.auditNote = auditNote;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getFlag() {
		return flag;
	}
}
