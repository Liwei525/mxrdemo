package cn.weicao.mxr.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class WarehouseUCGoods implements Serializable{
	private Integer wuid ;
	private Integer wid ;
	private Integer ucid ;
	private String name ;
	private String size ;
	private Integer unit ;
	private Integer num ;
	public Integer getWuid() {
		return wuid;
	}
	public void setWuid(Integer wuid) {
		this.wuid = wuid;
	}
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
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
	
}
