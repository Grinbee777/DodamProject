package com.dodam.service;

import java.util.List;

import com.dodam.service.domain.Baby;
import com.dodam.service.domain.User;

public interface BabyService {
	
	int insertBaby(Baby baby) throws Exception;
	
	Baby getBaby(int uNo) throws Exception;
	
	int updateBaby(Baby baby) throws Exception;
	
	int deleteBaby(int bNo)throws Exception;
	
	Baby getUNoBaby(int uNo) throws Exception;
}
