package com.dodam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.dao.UserDao;
import com.dodam.service.UserService;
import com.dodam.service.domain.User;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserServiceImpl() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

	@Override
	public int insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean checkDuplication(String userMail) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser(int userNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int userNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


}
