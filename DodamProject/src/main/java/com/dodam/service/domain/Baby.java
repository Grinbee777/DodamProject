
package com.dodam.service.domain;

import java.io.Serializable;

public class Baby implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int bNo;
	protected String bName;
	protected String bBirth;
	protected int bSex;
	protected String bNature;
	protected String bType;
	protected String bPhoto;
	protected User mom;
	
	public Baby() {
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbBirth() {
		return bBirth;
	}

	public void setbBirth(String bBirth) {
		this.bBirth = bBirth;
	}

	public int getbSex() {
		return bSex;
	}

	public void setbSex(int bSex) {
		this.bSex = bSex;
	}

	public String getbNature() {
		return bNature;
	}

	public void setbNature(String bNature) {
		this.bNature = bNature;
	}

	public String getbType() {
		return bType;
	}

	public void setbType(String bType) {
		this.bType = bType;
	}

	public String getbPhoto() {
		return bPhoto;
	}

	public void setbPhoto(String bPhoto) {
		this.bPhoto = bPhoto;
	}
	
	public User getMom(){
		return mom;
	}
	
	public void setMom(User mom){
		this.mom=mom;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Baby [bNo=");
		builder.append(bNo);
		builder.append(", bName=");
		builder.append(bName);
		builder.append(", bBirth=");
		builder.append(bBirth);
		builder.append(", bSex=");
		builder.append(bSex);
		builder.append(", bNature=");
		builder.append(bNature);
		builder.append(", bType=");
		builder.append(bType);
		builder.append(", bPhoto=");
		builder.append(bPhoto);
		builder.append(", mom=");
		builder.append(mom);
		builder.append("]");
		return builder.toString();
	}
		
}