package com.dodam.service.domain;

import java.io.Serializable;
import java.util.Date;

public class Diary implements Serializable {
	private static final long serialVersionUID = 1L;


	private int dNo;
	private String dPic;
	private String dContent;
	private Date dDate;
	private String dCode;
	private String dTag;
	private int bNo;
	private int uNo;
	
	public Diary() {
		// TODO Auto-generated constructor stub
	}

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}

	public String getdPic() {
		return dPic;
	}

	public void setdPic(String dPic) {
		this.dPic = dPic;
	}

	public String getdContent() {
		return dContent;
	}

	public void setdContent(String dContent) {
		this.dContent = dContent;
	}

	public Date getdDate() {
		return dDate;
	}

	public void setdDate(Date dDate) {
		this.dDate = dDate;
	}

	public String getdCode() {
		return dCode;
	}

	public void setdCode(String dCode) {
		this.dCode = dCode;
	}

	public String getdTag() {
		return dTag;
	}

	public void setdTag(String dTag) {
		this.dTag = dTag;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Diary [dNo=");
		builder.append(dNo);
		builder.append(", dPic=");
		builder.append(dPic);
		builder.append(", dContent=");
		builder.append(dContent);
		builder.append(", dDate=");
		builder.append(dDate);
		builder.append(", dCode=");
		builder.append(dCode);
		builder.append(", dTag=");
		builder.append(dTag);
		builder.append(", bNo=");
		builder.append(bNo);
		builder.append(", uNo=");
		builder.append(uNo);
		builder.append("]");
		return builder.toString();
	}
	
	
}
