package cn.weicao.mxr.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class UCGoodsStorageApplyWarehouse implements Serializable {
	private String usawid ;
	private String usaid ;
	private String note ;
	private Date date ;
	private String inmid ;
	public String getUsawid() {
		return usawid;
	}
	public void setUsawid(String usawid) {
		this.usawid = usawid;
	}
	public void setUsaid(String usaid) {
		this.usaid = usaid;
	}
	public String getUsaid() {
		return usaid;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getInmid() {
		return inmid;
	}
	public void setInmid(String inmid) {
		this.inmid = inmid;
	}
	
}
