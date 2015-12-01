package com.dodam.service;

import java.util.List;

import com.dodam.service.domain.SBaby;

public interface SBabyService {
	
	int insertSBaby(SBaby sBaby) throws Exception;

	SBaby getSBaby(int no) throws Exception;
	
	List<SBaby> getSBabyList(int bNo) throws Exception;
	
	int updateSBaby(SBaby sBaby) throws Exception;

	int deleteSBaby(int no) throws Exception;
}
