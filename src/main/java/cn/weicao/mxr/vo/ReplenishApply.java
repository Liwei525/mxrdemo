package cn.weicao.mxr.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ReplenishApply implements Serializable{
	private Integer raid ;
	private String name ;
	private Integer pid ;
	private Integer cid ;
	private Integer wid ;
	private String note ;
	private Integer status ;
	private String appMid ;
	private Date appDate ;
	private String sendMid ;
	private Date sendDate ;
	private String watchMid ;
	private Date watchDate ;
	private Integer flag ; //1代表未删除，0代表已删除
	public Integer getRaid() {
		return raid;
	}
	public void setRaid(Integer raid) {
		this.raid = raid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getWatchMid() {
		return watchMid;
	}
	public void setWatchMid(String watchMid) {
		this.watchMid = watchMid;
	}
	public Date getWatchDate() {
		return watchDate;
	}
	public void setWatchDate(Date watchDate) {
		this.watchDate = watchDate;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getFlag() {
		return flag;
	}
}
