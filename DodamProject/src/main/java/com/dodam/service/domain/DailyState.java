package com.dodam.service.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DailyState implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int dsNo;
	private int bNO;
	private Date dsDate;
	private List<Nap> dsNap;
	private List<Feed> dsFeed;
	private List<Poo> dsPoo;
	

	public DailyState() {
		// TODO Auto-generated constructor stub
	}


	public int getDsNo() {
		return dsNo;
	}


	public void setDsNo(int dsNo) {
		this.dsNo = dsNo;
	}


	public int getbNO() {
		return bNO;
	}


	public void setbNO(int bNO) {
		this.bNO = bNO;
	}


	public Date getDsDate() {
		return dsDate;
	}


	public void setDsDate(Date dsDate) {
		this.dsDate = dsDate;
	}


	public List<Nap> getDsNap() {
		return dsNap;
	}


	public void setDsNap(List<Nap> dsNap) {
		this.dsNap = dsNap;
	}


	public List<Feed> getDsFeed() {
		return dsFeed;
	}


	public void setDsFeed(List<Feed> dsFeed) {
		this.dsFeed = dsFeed;
	}


	public List<Poo> getDsPoo() {
		return dsPoo;
	}


	public void setDsPoo(List<Poo> dsPoo) {
		this.dsPoo = dsPoo;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DailyState [dsNo=");
		builder.append(dsNo);
		builder.append(", bNO=");
		builder.append(bNO);
		builder.append(", dsDate=");
		builder.append(dsDate);
		builder.append(", dsNap=");
		builder.append(dsNap);
		builder.append(", dsFeed=");
		builder.append(dsFeed);
		builder.append(", dsPoo=");
		builder.append(dsPoo);
		builder.append("]");
		return builder.toString();
	}
	
}
