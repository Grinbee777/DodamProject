package com.dodam.service.domain;

import java.io.Serializable;

public class Nap implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int nNo;
	private String nStart;
	private String nEnd;
	private int nState;
	private int dsNo;
	
	public Nap() {
		super();
	}

	public Nap(int nNo, String nStart, String nEnd, int nState, int dsNo) {
		super();
		this.nNo = nNo;
		this.nStart = nStart;
		this.nEnd = nEnd;
		this.nState = nState;
		this.dsNo = dsNo;
	}

	public int getnNo() {
		return nNo;
	}

	public void setnNo(int nNo) {
		this.nNo = nNo;
	}

	public String getnStart() {
		return nStart;
	}

	public void setnStart(String nStart) {
		this.nStart = nStart;
	}

	public String getnEnd() {
		return nEnd;
	}

	public void setnEnd(String nEnd) {
		this.nEnd = nEnd;
	}

	public int getnState() {
		return nState;
	}

	public void setnState(int nState) {
		this.nState = nState;
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
		builder.append("Nap [nNo=");
		builder.append(nNo);
		builder.append(", nStart=");
		builder.append(nStart);
		builder.append(", nEnd=");
		builder.append(nEnd);
		builder.append(", nState=");
		builder.append(nState);
		builder.append(", dsNo=");
		builder.append(dsNo);
		builder.append("]");
		return builder.toString();
	}
	
}
