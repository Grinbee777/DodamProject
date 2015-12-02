package com.dodam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.dao.DailyStateDao;
import com.dodam.service.DailyStateService;
import com.dodam.service.domain.DailyState;

@Service("dailyStateServiceImpl")
public class DailyStateServiceImpl implements DailyStateService {
	
	@Autowired
	private DailyStateDao dailyStateDao;
	public void setDailyStateDao(DailyStateDao dailyStateDao){
		this.dailyStateDao = dailyStateDao;
	}
	
	public DailyStateServiceImpl() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

	@Override
	public int insertDState(DailyState dailyState) {		
		return dailyStateDao.insertDState(dailyState);
	}

	@Override
	public DailyState getDailyState(DailyState dailyState) {
		return dailyStateDao.getDailyState(dailyState);
	}

	@Override
	public List<DailyState> getDailyStateList(int bNo) {
		return dailyStateDao.getDailyStateList(bNo);
	}

	@Override
	public int deleteDailyStateByDate(DailyState dailyState) {
		return deleteDailyStateByDate(dailyState);
	}

	@Override
	public int deleteDailyStateByBaby(DailyState dailyState) {
		return dailyStateDao.deleteDailyStateByBaby(dailyState);
	}
	
}
