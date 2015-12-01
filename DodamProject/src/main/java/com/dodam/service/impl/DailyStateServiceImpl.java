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
	public int insertDState() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DailyState getDailyState(int bNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DailyState> getDailyStateList(int bNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteDailyState(int no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
