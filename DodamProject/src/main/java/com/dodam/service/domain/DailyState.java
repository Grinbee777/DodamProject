package com.dodam.service.domain;

import java.io.Serializable;
import java.util.Date;

public class DailyState implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int dsNo;
	private int bNO;
	private Date dsDate;
	

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


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DailyState [dsNo=");
		builder.append(dsNo);
		builder.append(", bNO=");
		builder.append(bNO);
		builder.append(", dsDate=");
		builder.append(dsDate);
		builder.append("]");
		return builder.toString();
	}

}
