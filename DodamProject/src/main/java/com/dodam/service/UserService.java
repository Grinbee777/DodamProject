package com.dodam.service;


import java.util.List;

import com.dodam.service.domain.User;


public interface UserService {
	
	int insertUser(User user) throws Exception;
	
	User getUser(int uNo) throws Exception;
	
	User getMailUser(String mail) throws Exception;
	
	User getNickUser(String nickname) throws Exception;
	
	List<User> getUserList() throws Exception;
	
	int updateUser(User user) throws Exception;
	
	int deleteUser(int uNo) throws Exception;
	
	boolean loginUser(User user) throws Exception;
	
	int uCodeUpdate(int uNo) throws Exception;

}
