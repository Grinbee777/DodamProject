package com.dodam.service.domain;

import java.io.Serializable;

public class Poo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int pNo;
	private String pTime;
	private int dsNo;
	
	public Poo(){
	}

	public Poo(int pNo, String pTime, int dsNo) {
		super();
		this.pNo = pNo;
		this.pTime = pTime;
		this.dsNo = dsNo;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getpTime() {
		return pTime;
	}

	public void setpTime(String pTime) {
		this.pTime = pTime;
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
		builder.append("Poo [pNo=");
		builder.append(pNo);
		builder.append(", pTime=");
		builder.append(pTime);
		builder.append(", dsNo=");
		builder.append(dsNo);
		builder.append("]");
		return builder.toString();
	}
	
	
}
