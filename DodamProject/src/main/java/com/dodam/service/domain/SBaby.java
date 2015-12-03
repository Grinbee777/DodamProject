package com.dodam.service.domain;

import java.io.Serializable;

public class SBaby implements Serializable {
	private static final long serialVersionUID = 1L;

	private int sbNo;
	private String height;
	private String weight;
	private int dNo;
	private int bNo;
	
	
	public int getSbNo() {
		return sbNo;
	}
	public void setSbNo(int sbNo) {
		this.sbNo = sbNo;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public int getdNo() {
		return dNo;
	}
	public void setdNo(int dNo) {
		this.dNo = dNo;
	}
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	
	@Override
	public String toString() {
		return "SBaby [sbNo=" + sbNo + ", height=" + height + ", weight=" + weight + ", dNo=" + dNo + ", bNo="
				+ bNo + "]";
	}
	
	
	
	
}
