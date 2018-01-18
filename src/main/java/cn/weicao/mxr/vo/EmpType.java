package cn.weicao.mxr.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EmpType implements Serializable{
	private Integer etid ;
	private String title ;
	public Integer getEtid() {
		return etid;
	}
	public void setEtid(Integer etid) {
		this.etid = etid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
