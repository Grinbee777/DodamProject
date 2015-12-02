package com.dodam.service.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DailyState implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int dsNo;
	private int bNO;
	private Date dsDate;
	private List<Nap> nap;
	private List<Feed> feed;
	private List<Poo> poo;
	

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


	public List<Nap> getNap() {
		return nap;
	}


	public void setNap(List<Nap> nap) {
		this.nap = nap;
	}


	public List<Feed> getFeed() {
		return feed;
	}


	public void setFeed(List<Feed> feed) {
		this.feed = feed;
	}


	public List<Poo> getPoo() {
		return poo;
	}


	public void setPoo(List<Poo> poo) {
		this.poo = poo;
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
		builder.append(", nap=");
		builder.append(nap);
		builder.append(", feed=");
		builder.append(feed);
		builder.append(", poo=");
		builder.append(poo);
		builder.append("]");
		return builder.toString();
	}
	
	
}
