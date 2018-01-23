package cn.weicao.mxr.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ReplenishApply implements Serializable{
	private Integer raid ;
	private String name ;
	private Integer pid ;
	private Integer cid ;
	private Integer ucwid ;
	private String note ;
	private Integer status ;
	private String appMid ;
	private Date appDate ;
	private String sendMid ;
	private Date sendDate ;
	private String watchMid ;
	private Date watchDate ;
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
	public Integer getUcwid() {
		return ucwid;
	}
	public void setUcwid(Integer ucwid) {
		this.ucwid = ucwid;
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
	
}
