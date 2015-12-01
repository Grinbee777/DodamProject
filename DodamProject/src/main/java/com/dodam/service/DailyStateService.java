package com.dodam.service;

import java.util.List;

import com.dodam.service.domain.DailyState;

public interface DailyStateService {
	
	int insertDState() throws Exception;
	
	DailyState getDailyState(int bNo) throws Exception;
	
	List<DailyState> getDailyStateList(int bNo) throws Exception;

	int deleteDailyState(int no) throws Exception; 
}
