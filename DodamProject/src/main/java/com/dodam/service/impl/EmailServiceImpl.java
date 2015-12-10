package com.dodam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.dao.EmailDao;
import com.dodam.service.EmailService;
import com.dodam.service.domain.Email;

@Service("emailServiceImpl")
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailDao emailDao;
	public void setEmailDao(EmailDao emailDao) {
		this.emailDao=emailDao;
	}
	
	public EmailServiceImpl(){
		System.out.println("이메일 서비스임플 들어옴");
	}
	
	@Override
	public int insertEmail(Email email) throws Exception {
		return emailDao.insertEmail(email);
	}
}
