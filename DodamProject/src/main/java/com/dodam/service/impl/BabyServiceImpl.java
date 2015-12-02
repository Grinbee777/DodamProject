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
	public int addBaby(Baby baby) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Baby getBaby(int bNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

/*	@Override
	public List<User> getUserList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public int updateBaby(Baby baby) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBaby(int bNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
