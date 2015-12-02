package com.dodam.service;


import java.util.List;

import com.dodam.service.domain.User;


public interface UserService {
	
	int insertUser(User user) throws Exception;
	
	boolean checkDuplication(String mail) throws Exception;
	
	User getUser(int uNo) throws Exception;

	List<User> getUserList() throws Exception;
	
	int updateUser(User user) throws Exception;
	
	int deleteUser(int uNo) throws Exception;

}
