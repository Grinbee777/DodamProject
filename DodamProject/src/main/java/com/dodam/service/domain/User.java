package com.dodam.service.domain;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int uNo;
	private String mail;
	private String uPic;
	private int uPcode;
	private String password;
	private String socialNo;
	private String uBirth;
	private String regDate;
	private String nickname;
	private String authnum;
	private String uCode;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getuPic() {
		return uPic;
	}

	public void setuPic(String uPic) {
		this.uPic = uPic;
	}

	public int getuPcode() {
		return uPcode;
	}

	public void setuPcode(int uPcode) {
		this.uPcode = uPcode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSocialNo() {
		return socialNo;
	}

	public void setSocialNo(String socialNo) {
		this.socialNo = socialNo;
	}

	public String getuBirth() {
		return uBirth;
	}

	public void setuBirth(String uBirth) {
		this.uBirth = uBirth;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getAuthnum(){
		return authnum;
	}
	
	public void setAuthnum(String authnum){
		this.authnum=authnum;
	}

	public String getuCode() {
		return uCode;
	}

	public void setuCode(String uCode) {
		this.uCode = uCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [uNo=");
		builder.append(uNo);
		builder.append(", mail=");
		builder.append(mail);
		builder.append(", uPic=");
		builder.append(uPic);
		builder.append(", uPcode=");
		builder.append(uPcode);
		builder.append(", password=");
		builder.append(password);
		builder.append(", socialNo=");
		builder.append(socialNo);
		builder.append(", uBirth=");
		builder.append(uBirth);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", nickname=");
		builder.append(nickname);
		builder.append(", authnum=");
		builder.append(authnum);
		builder.append(", uCode=");
		builder.append(uCode);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
