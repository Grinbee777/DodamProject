package com.dodam.dao;

import java.util.List;

import com.dodam.service.domain.Baby;

public interface BabyDao {
	int addBaby(Baby baby);
	Baby getBaby(int bNo);
	//파라메터 정할것...Serch 객체 활용?
	//조건 - 회원의 모든 등록된 아기, ...?
	List<Baby> getBabyList();
	int updateBaby(Baby baby);
	int deleteBaby(int bNo);
}
