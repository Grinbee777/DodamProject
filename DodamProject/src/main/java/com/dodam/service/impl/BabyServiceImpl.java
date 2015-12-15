package com.dodam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.dao.BabyDao;
import com.dodam.service.BabyService;
import com.dodam.service.domain.Baby;
import com.dodam.service.domain.User;

@Service("babyServiceImpl")
public class BabyServiceImpl implements BabyService {
	
	@Autowired
	private BabyDao babyDao;
	public void setBabyDao(BabyDao babyDao) {
		this.babyDao= babyDao;
	}

	public BabyServiceImpl() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

	@Override
	public int insertBaby(Baby baby) throws Exception {
		return babyDao.insertBaby(baby);
	}

	@Override
	public Baby getBaby(int bNo) throws Exception {
		return babyDao.getBaby(bNo);
	}

/*	@Override
	public List<User> getUserList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public int updateBaby(Baby baby) throws Exception {
		return babyDao.updateBaby(baby);
	}

	@Override
	public int deleteBaby(int bNo) throws Exception {
		return babyDao.deleteBaby(bNo);
	}
	
	@Override
	public Baby getUNoBaby(int uNo) throws Exception {
		return babyDao.getUNoBaby(uNo);
	}
}
