package com.dodam.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jca.cci.connection.ConnectionFactoryUtils;
import org.springframework.stereotype.Service;

import com.dodam.common.SendEmail;
import com.dodam.dao.EmailDao;
import com.dodam.dao.UserDao;
import com.dodam.service.UserService;
import com.dodam.service.domain.Email;
import com.dodam.service.domain.User;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	private SqlSession sqlSession;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Autowired
	private EmailDao emailDao;
	public void setEmailDao(Email email){
		this.emailDao=emailDao;
	}
	
	public UserServiceImpl() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}
	
	public int insertUser(User user) throws Exception {
		int result= userDao.insertUser(user);
		
		if(result==1) {
			String authNum=String.valueOf(Math.round((Math.random()*10000000)));
			System.out.println("난수 ::"+authNum+"메일주소 ::"+user.getMail());
			
			Email email=new Email();
			email.setAuthnum(authNum);
			email.setuNo(user.getuNo());
			email.setMail(user.getMail());
			
			emailDao.insertEmail(email);
			
			SendEmail sendEmail=new SendEmail();
			sendEmail.sendEmail(email, authNum,user);
				
		}
		
		return result;
	}	
	
	public User getUser(int uNo) throws Exception {		
		return userDao.getUser(uNo);
	}
	
	public User getMailUser(String mail) throws Exception {		
		return userDao.getMailUser(mail);
	}
	public User getNickUser(String nickname) throws Exception {		
		return userDao.getNickUser(nickname);
	}
	
	public List<User> getUserList() throws Exception {		
		return userDao.getUserList();
	}
	
	public int updateUser(User user) throws Exception {		
		return userDao.updateUser(user);
	}
	
	public int deleteUser(int uNo) throws Exception {
		return userDao.deleteUser(uNo);
	}

	@Override
	public int loginUser(User user) throws Exception {
		int result = 0;
		System.out.println("user :"+user);
		User dbUser = userDao.loginUser(user);
		System.out.println("dbUser :"+dbUser);
		try {
			if (dbUser != null ) {
				if (user.getPassword().equals(dbUser.getPassword()) ) {
					//email 인증 로직 추가
					if (dbUser.getuCode().trim().equals("1")) {
						System.out.println("user needed to confirm email");
						result = 1;
					} else if(dbUser.getuCode().trim().equals("2")){
						System.out.println("user confirmed by email");
						result = 2;
					}				
				}else{
					System.out.println("Wrong Usre Information");
				}			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			
		}			
		
		return result;
	}
	
	public int uCodeUpdate(int uNo) throws Exception {
		return userDao.uCodeUpdate(uNo);
	}

}
