package cn.weicao.mxr.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ReplenishApplyDetails implements Serializable{
	private Integer radid ;
	private Integer raid ;
	private Integer ucid ;
	private String name ;
	private String size ;
	private Double price ;
	private Integer unit ;
	private Integer num ;
	private Double totalPrice ;
	public Integer getRadid() {
		return radid;
	}
	public void setRadid(Integer radid) {
		this.radid = radid;
	}
	public Integer getRaid() {
		return raid;
	}
	public void setRaid(Integer raid) {
		this.raid = raid;
	}
	public Integer getUcid() {
		return ucid;
	}
	public void setUcid(Integer ucid) {
		this.ucid = ucid;
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
}
