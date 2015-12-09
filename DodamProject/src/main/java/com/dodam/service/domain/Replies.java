package com.dodam.service.domain;

import java.io.Serializable;
import java.sql.Date;

public class Replies implements Serializable {
	private static final long serialVersionUID = 1L;

	private int rNo;
	private int rUNo;
	private User rUser;
	private String rContent;
	private int pNo;
	private int rOrder;
	private int rLevel;
	private Date rDate;
	private int dNo;
	
	public Replies(){
		
	}

	public Replies(int rNo, int rUNo, User rUser, String rContent, int pNo, int rOrder, int rLevel, Date rDate,
			int dNo) {
		super();
		this.rNo = rNo;
		this.rUNo = rUNo;
		this.rUser = rUser;
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

	public int getrUNo() {
		return rUNo;
	}

	public void setrUNo(int rUNo) {
		this.rUNo = rUNo;
	}

	public User getrUser() {
		return rUser;
	}

	public void setrUser(User rUser) {
		this.rUser = rUser;
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
		StringBuilder builder = new StringBuilder();
		builder.append("Replies [rNo=");
		builder.append(rNo);
		builder.append(", rUNo=");
		builder.append(rUNo);
		builder.append(", rUser=");
		builder.append(rUser);
		builder.append(", rContent=");
		builder.append(rContent);
		builder.append(", pNo=");
		builder.append(pNo);
		builder.append(", rOrder=");
		builder.append(rOrder);
		builder.append(", rLevel=");
		builder.append(rLevel);
		builder.append(", rDate=");
		builder.append(rDate);
		builder.append(", dNo=");
		builder.append(dNo);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
