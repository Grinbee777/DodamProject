package com.dodam.service.domain;

import java.io.Serializable;

public class Friend implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int frNo;
	private int uNo;
	private int frMate;
	private int frState;
	private User user;
	
	public Friend() {
		// TODO Auto-generated constructor stub
	}

	public int getFrNo() {
		return frNo;
	}

	public void setFrNo(int frNo) {
		this.frNo = frNo;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Friend [frNo=");
		builder.append(frNo);
		builder.append(", uNo=");
		builder.append(uNo);
		builder.append(", frMate=");
		builder.append(frMate);
		builder.append(", frState=");
		builder.append(frState);
		builder.append("]");
		return builder.toString();
	}

	
	

}
