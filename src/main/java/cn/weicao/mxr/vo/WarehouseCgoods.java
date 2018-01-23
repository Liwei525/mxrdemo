package cn.weicao.mxr.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class WarehouseCgoods implements Serializable{
	private Integer wcid ;
	private Integer wid ;
	private Integer cid ;
	private String name ;
	private String size ;
	private Integer num ;
	public Integer getWcid() {
		return wcid;
	}
	public void setWcid(Integer wcid) {
		this.wcid = wcid;
	}
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
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
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
}
