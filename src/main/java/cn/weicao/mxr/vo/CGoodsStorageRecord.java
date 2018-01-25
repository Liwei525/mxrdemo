package cn.weicao.mxr.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class CGoodsStorageRecord implements Serializable{
	private Integer csrid ;
	private Integer ppid ;
	private Integer cid ;
	private Integer wid ;
	private String name ;
	private String size ;
	private Double price ;
	private Integer num ;
	private Double totalPrice ;
	private Date date ;
	public Integer getCsrid() {
		return csrid;
	}
	public void setCsrid(Integer csrid) {
		this.csrid = csrid;
	}
	public Integer getPpid() {
		return ppid;
	}
	public void setPpid(Integer ppid) {
		this.ppid = ppid;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
}
