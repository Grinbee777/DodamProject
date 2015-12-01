package com.dodam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.dao.SBabyDao;
import com.dodam.service.SBabyService;
import com.dodam.service.domain.SBaby;

@Service("sBabyServiceImpl")
public class SBabyServiceImpl implements SBabyService {
	
	@Autowired
	private SBabyDao sBabyDao;
	public void setSBabtDao(SBabyDao sBabyDao){
		this.sBabyDao = sBabyDao;
	}
	
	public SBabyServiceImpl() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

	@Override
	public int insertSBaby(SBaby sBaby) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SBaby getSBaby(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SBaby> getSBabyList(int bNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateSBaby(SBaby sBaby) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSBaby(int no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
