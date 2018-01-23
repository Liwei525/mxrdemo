package cn.weicao.mxr.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Citem implements Serializable{
	private Integer ciid ;
	private String title ;
	public Integer getCiid() {
		return ciid;
	}
	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
