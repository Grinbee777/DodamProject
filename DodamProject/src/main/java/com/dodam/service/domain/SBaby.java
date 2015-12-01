package com.dodam.service.domain;

import java.io.Serializable;

public class SBaby implements Serializable {
	private static final long serialVersionUID = 1L;

	private int sbNo;
	private float height;
	private float weight;
	private int dNo;
	private int bNo;
	
	
	public int getSbNo() {
		return sbNo;
	}
	public void setSbNo(int sbNo) {
		this.sbNo = sbNo;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
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
