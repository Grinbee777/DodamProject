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

import com.dodam.dao.UserDao;
import com.dodam.service.UserService;
import com.dodam.service.domain.User;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	private SqlSession sqlSession;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserServiceImpl() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}
	
	public int insertUser(User user) throws Exception {
		return userDao.insertUser(user);
	}	
	
	public User getUser(int uNo) throws Exception {		
		return userDao.getUser(uNo);
	}
	
	public User getMailUser(String mail) throws Exception {		
		return userDao.getMailUser(mail);
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
	public boolean loginUser(User user) throws Exception {
		boolean result = false;
		User dbUser = userDao.loginUser(user);
		
		if (dbUser != null ) {
			if (user.getPassword().equals(dbUser.getPassword()) ) {
				result =true;
			}			
		}	
		return result;
	}

}
