package com.dodam.service.domain;

import java.io.Serializable;
import java.sql.Date;

public class Replies implements Serializable {
	private static final long serialVersionUID = 1L;

	private int rNo;
	private String rName;
	private String rContent;
	private int pNo;
	private int rOrder;
	private int rLevel;
	private Date rDate;
	private int dNo;
	
	public Replies(){
		
	}
	
	public Replies(int rNo, String rName, String rContent, int pNo, int rOrder, int rLevel, Date rDate, int dNo) {
		super();
		this.rNo = rNo;
		this.rName = rName;
		this.rContent = rContent;
		this.pNo = pNo;
		this.rOrder = rOrder;
		this.rLevel = rLevel;
		this.rDate = rDate;
		this.dNo = dNo;
	}
	
	public int getrNo() {
		return rNo;
	}
	public void setrNo(int rNo) {
		this.rNo = rNo;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public int getrOrder() {
		return rOrder;
	}
	public void setrOrder(int rOrder) {
		this.rOrder = rOrder;
	}
	public int getrLevel() {
		return rLevel;
	}
	public void setrLevel(int rLevel) {
		this.rLevel = rLevel;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	public int getdNo() {
		return dNo;
	}
	public void setdNo(int dNo) {
		this.dNo = dNo;
	}
	
	@Override
	public String toString() {
		return "Replies [rNo=" + rNo + ", rName=" + rName + ", rContent=" + rContent + ", pNo=" + pNo + ", rOrder="
				+ rOrder + ", rLevel=" + rLevel + ", rDate=" + rDate + ", dNo=" + dNo + "]";
	}
	
	
}
