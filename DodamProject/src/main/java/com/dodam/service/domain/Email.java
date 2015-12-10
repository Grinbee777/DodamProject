package com.dodam.service.domain;

import java.io.Serializable;

public class Email implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String authnum;
	private int uNo;
	private String mail;
	
	public Email(){
		
	}

	public String getAuthnum() {
		return authnum;
	}

	public void setAuthnum(String authnum) {
		this.authnum = authnum;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Email [authnum=");
		builder.append(authnum);
		builder.append(", uNo=");
		builder.append(uNo);
		builder.append(", mail=");
		builder.append(mail);
		builder.append("]");
		return builder.toString();
	}


	
	
}
