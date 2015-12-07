package com.dodam.dao;

import java.util.List;

import com.dodam.service.domain.User;

public interface UserDao {
	
	public int insertUser(User user)throws Exception;
	
	public boolean checkDuplication(String mail)throws Exception;
	
	public User getUser(int uNo)throws Exception;
	
	//친구기능 추가시 파라메터 값 결정
	public List<User> getUserList()throws Exception;
	
	public int updateUser(User user)throws Exception;

	public int deleteUser(int uNo)throws Exception;

	public User loginUser(User user) throws Exception;

}
