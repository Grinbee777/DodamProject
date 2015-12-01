package com.dodam.dao;

import java.util.List;

import com.dodam.service.domain.User;

public interface UserDao {
	
	int insertUser(User user);
	boolean checkDuplication(String mail);
	User getUser(int uNo);
	//친구기능 추가시 파라메터 값 결정
	List<User> getUserList();
	int updateUser(User user);
	int deleteUser(int uNo);

}
