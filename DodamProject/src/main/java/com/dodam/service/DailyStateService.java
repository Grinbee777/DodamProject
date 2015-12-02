package com.dodam.service;

import java.util.List;

import com.dodam.service.domain.DailyState;

public interface DailyStateService {
	
	int insertDState(DailyState dailyState);

	DailyState getDailyState(DailyState dailyState);
	
	List<DailyState> getDailyStateList(int bNo);

	int deleteDailyStateByDate(DailyState dailyState);

	int deleteDailyStateByBaby(DailyState dailyState);
}
