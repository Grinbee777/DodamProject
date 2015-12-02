package com.dodam.dao;

import java.util.List;

import com.dodam.common.DailyStateSearch;
import com.dodam.service.domain.DailyState;

public interface DailyStateDao {
	int insertDState(int bNo);
	//dsNo, 날짜 전달
	DailyState getDailyState(DailyStateSearch dailyStateSearch);
	List<DailyState> getDailyStateList(int bNo);
	//dsNo or bNo 전달
	int deleteDailyState(int no); 
}
