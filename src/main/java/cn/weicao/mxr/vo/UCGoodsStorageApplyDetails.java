package cn.weicao.mxr.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UCGoodsStorageApplyDetails implements Serializable{
	private Integer usadid ;
	private String usaid ;
	private Integer ucid ;
	private String name ;
	private String size ;
	private Double price ;
	private Integer unit ;
	private Integer num ;
	private Double totalPrice ;
	public Integer getUsadid() {
		return usadid;
	}
	public void setUsadid(Integer usadid) {
		this.usadid = usadid;
	}
	public String getUsaid() {
		return usaid;
	}
	public void setUsaid(String usaid) {
		this.usaid = usaid;
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
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getPrice() {
		return price;
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
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	
}
