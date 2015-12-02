package com.dodam.dao;

import java.util.List;

import com.dodam.service.domain.DailyState;

public interface DailyStateDao {
	int insertDState(DailyState dailyState);
	DailyState getDailyState(DailyState dailyState);
	List<DailyState> getDailyStateList(int bNo);
	//날짜별 삭제
	int deleteDailyStateByDate(DailyState dailyState);
	//아기별 삭제
	int deleteDailyStateByBaby(DailyState dailyState);
}
