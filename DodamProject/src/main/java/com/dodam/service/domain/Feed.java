package com.dodam.service.domain;

import java.io.Serializable;

public class Feed implements Serializable {
	private static final long serialVersionUID = 1L;

	private int fNo;
	private String fTime;
	private int fAmount;
	private int dsNo;
	
	public Feed(){
	}

	public Feed(int fNo, String fTime, int fAmount, int dsNo) {
		super();
		this.fNo = fNo;
		this.fTime = fTime;
		this.fAmount = fAmount;
		this.dsNo = dsNo;
	}

	public int getfNo() {
		return fNo;
	}

	public void setfNo(int fNo) {
		this.fNo = fNo;
	}

	public String getfTime() {
		return fTime;
	}

	public void setfTime(String fTime) {
		this.fTime = fTime;
	}

	public int getfAmount() {
		return fAmount;
	}

	public void setfAmount(int fAmount) {
		this.fAmount = fAmount;
	}

	public int getDsNo() {
		return dsNo;
	}

	public void setDsNo(int dsNo) {
		this.dsNo = dsNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Feed [fNo=");
		builder.append(fNo);
		builder.append(", fTime=");
		builder.append(fTime);
		builder.append(", fAmount=");
		builder.append(fAmount);
		builder.append(", dsNo=");
		builder.append(dsNo);
		builder.append("]");
		return builder.toString();
	}
	
	
}