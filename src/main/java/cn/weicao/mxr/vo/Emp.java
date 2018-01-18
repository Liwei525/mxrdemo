package cn.weicao.mxr.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Emp implements Serializable{
	private String eid ;
	private Integer lid ;
	private Integer did ;
	private Integer sex ;
	private Integer etid ;
	private String ename ;
	private Double salary ;
	private String phone ;
	private String password ;
	private String photo ;
	private String empnote ;
	private Date hiredate ;
	private String ineid ;
	private Integer state ; //0表示离职，1表示在职
	private Date leaveDate ;
	private String leaveNote ;
	private String outeid ;
	private Date lastDate ;
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getEtid() {
		return etid;
	}
	public void setEtid(Integer etid) {
		this.etid = etid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmpnote() {
		return empnote;
	}
	public void setEmpnote(String empnote) {
		this.empnote = empnote;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public String getIneid() {
		return ineid;
	}
	public void setIneid(String ineid) {
		this.ineid = ineid;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getLeaveNote() {
		return leaveNote;
	}
	public void setLeaveNote(String leaveNote) {
		this.leaveNote = leaveNote;
	}
	public String getOuteid() {
		return outeid;
	}
	public void setOuteid(String outeid) {
		this.outeid = outeid;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public Date getLastDate() {
		return lastDate;
	}
	
}
