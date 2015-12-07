package com.dodam.service.domain;

import java.io.Serializable;

public class Friend implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int frNo;
	private int fruNo;
	private int frMate;
	private int frState;
	
	public Friend() {
		// TODO Auto-generated constructor stub
	}

	public int getFrNo() {
		return frNo;
	}

	public void setFrNo(int frNo) {
		this.frNo = frNo;
	}

	public int getFruNo() {
		return fruNo;
	}

	public void setFruNo(int fruNo) {
		this.fruNo = fruNo;
	}

	public int getFrMate() {
		return frMate;
	}

	public void setFrMate(int frMate) {
		this.frMate = frMate;
	}

	public int getFrState() {
		return frState;
	}

	public void setFrState(int frState) {
		this.frState = frState;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Friend [frNo=");
		builder.append(frNo);
		builder.append(", fruNo=");
		builder.append(fruNo);
		builder.append(", frMate=");
		builder.append(frMate);
		builder.append(", frState=");
		builder.append(frState);
		builder.append("]");
		return builder.toString();
	}
	
	

}
