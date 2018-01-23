package cn.weicao.mxr.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductPlanDetails implements Serializable{
	private Integer ppdid ;
	private Integer ppid ;
	private Integer cid ;
	private String name ;
	private String size ;
	private Double price ;
	private Integer num ;
	private Double totalPrice ;
	public Integer getPpdid() {
		return ppdid;
	}
	public void setPpdid(Integer ppdid) {
		this.ppdid = ppdid;
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
	
}
