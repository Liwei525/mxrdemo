package cn.weicao.mxr.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class UCGoodsStorageApplyRecord implements Serializable {
	private Integer usarid ;
	private String usawid ;
	private Integer ucid ;
	private Integer wid ;
	private String name ;
	private String size ;
	private Double price ;
	private Integer unit ;
	private Integer num ;
	private Double totalPrice ;
	private Date date ;
	public Integer getUsarid() {
		return usarid;
	}
	public void setUsarid(Integer usarid) {
		this.usarid = usarid;
	}
	public String getUsawid() {
		return usawid;
	}
	public void setUsawid(String usawid) {
		this.usawid = usawid;
	}
	public Integer getUcid() {
		return ucid;
	}
	public void setUcid(Integer ucid) {
		this.ucid = ucid;
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
	public Integer getUnit() {
		return unit;
	}
	public void setUnit(Integer unit) {
		this.unit = unit;
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
