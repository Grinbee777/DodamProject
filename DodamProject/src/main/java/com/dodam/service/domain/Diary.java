package com.dodam.service.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class Diary implements Serializable {
	private static final long serialVersionUID = 1L;


	private int dNo;
	private String[] dPics;
	private String dPic;
	private String dContent;
	private Date dDate;
	private String dCode;
	private String dTag;
	private String[] dTags;
	private String uPic;
	private int bNo;
	private int uNo;
	private Baby diaryBaby;
	private User diaryUser;
	private Replies diaryReplies;
	private List<Replies> replyList;
	private int replyCount;
	private List<Like> likeList;
	private int likeCount;
	
	public Diary() {
		// TODO Auto-generated constructor stub
	}

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}

	public String[] getdPics() {
		return dPics;
	}

	public void setdPics(String[] dPics) {
		this.dPics = dPics;
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

	public String[] getdTags() {
		return dTags;
	}

	public void setdTags(String[] dTags) {
		this.dTags = dTags;
	}

	public String getuPic() {
		return uPic;
	}

	public void setuPic(String uPic) {
		this.uPic = uPic;
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

	public Baby getDiaryBaby() {
		return diaryBaby;
	}

	public void setDiaryBaby(Baby diaryBaby) {
		this.diaryBaby = diaryBaby;
	}

	public User getDiaryUser() {
		return diaryUser;
	}

	public void setDiaryUser(User diaryUser) {
		this.diaryUser = diaryUser;
	}

	public Replies getDiaryReplies() {
		return diaryReplies;
	}

	public void setDiaryReplies(Replies diaryReplies) {
		this.diaryReplies = diaryReplies;
	}

	public List<Replies> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Replies> replyList) {
		this.replyList = replyList;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public List<Like> getLikeList() {
		return likeList;
	}

	public void setLikeList(List<Like> likeList) {
		this.likeList = likeList;
	}
	
	
	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Diary [dNo=");
		builder.append(dNo);
		builder.append(", dPics=");
		builder.append(Arrays.toString(dPics));
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
		builder.append(", dTags=");
		builder.append(Arrays.toString(dTags));
		builder.append(", uPic=");
		builder.append(uPic);
		builder.append(", bNo=");
		builder.append(bNo);
		builder.append(", uNo=");
		builder.append(uNo);
		builder.append(", diaryBaby=");
		builder.append(diaryBaby);
		builder.append(", diaryUser=");
		builder.append(diaryUser);
		builder.append(", diaryReplies=");
		builder.append(diaryReplies);
		builder.append(", replyList=");
		builder.append(replyList);
		builder.append(", replyCount=");
		builder.append(replyCount);
		builder.append(", likeList=");
		builder.append(likeList);
		builder.append(", likeCount=");
		builder.append(likeCount);
		builder.append("]");
		return builder.toString();
	}

		
}
