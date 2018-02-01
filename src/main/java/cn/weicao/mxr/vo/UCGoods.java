package cn.weicao.mxr.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class UCGoods implements Serializable {
	private Integer ucid ;
	private String name ;
	private Double price ;
	private String size ;
	private Integer unit ; // 1表示个数，2表示长度（米）
	private String photo ;
	private String note ;
	private Date lastin ;
	private int stornum ; 
	private String recorder ;
	private String pinyin ;
	private Integer flag ; //1代表未删除，0代表已删除
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getLastin() {
		return lastin;
	}
	public void setLastin(Date lastin) {
		this.lastin = lastin;
	}
	public int getStornum() {
		return stornum;
	}
	public void setStornum(int stornum) {
		this.stornum = stornum;
	}
	public String getRecorder() {
		return recorder;
	}
	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getFlag() {
		return flag;
	}
}
