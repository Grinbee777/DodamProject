package com.dodam.service.domain;

public class Like {
	private int lNo;
	private int lState;
	private int dNo;
	private int uNo;
	private Diary likeDiary;
	private User likeUser;
	
	public Like(){
		
	}

	public int getlNo() {
		return lNo;
	}

	public void setlNo(int lNo) {
		this.lNo = lNo;
	}

	public int getlState() {
		return lState;
	}

	public void setlState(int lState) {
		this.lState = lState;
	}

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public Diary getLikeDiary() {
		return likeDiary;
	}

	public void setLikeDiary(Diary likeDiary) {
		this.likeDiary = likeDiary;
	}

	public User getLikeUser() {
		return likeUser;
	}

	public void setLikeUser(User likeUser) {
		this.likeUser = likeUser;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Like [lNo=");
		builder.append(lNo);
		builder.append(", lState=");
		builder.append(lState);
		builder.append(", dNo=");
		builder.append(dNo);
		builder.append(", uNo=");
		builder.append(uNo);
		builder.append(", likeDiary=");
		builder.append(likeDiary);
		builder.append(", likeUser=");
		builder.append(likeUser);
		builder.append("]");
		return builder.toString();
	}
	
}
