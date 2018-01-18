package cn.weicao.mxr.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Dept implements Serializable{
	private Integer did ;
	private String dname ;
	private String eid ;
	private Integer maxnum ;
	private Integer currnum ;
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public Integer getMaxnum() {
		return maxnum;
	}
	public void setMaxnum(Integer maxnum) {
		this.maxnum = maxnum;
	}
	public Integer getCurrnum() {
		return currnum;
	}
	public void setCurrnum(Integer currnum) {
		this.currnum = currnum;
	}
	
}
