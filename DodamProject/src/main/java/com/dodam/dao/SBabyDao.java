package com.dodam.dao;

import java.util.List;

import com.dodam.service.domain.SBaby;

public interface SBabyDao {
	int insertSBaby(SBaby sBaby);
	//다이어리에서 정보 요청시 dNo, 아기정보에서 요청시 babyNo
	//SBaby getSBaby(int no);
	//List<SBaby> getSBabyList(int bNo);
	int updateSBaby(SBaby sBaby);
	//1개 삭제시 sbNo or dNo, 일괄삭제시 babyNo 
	int deleteSBaby(int no);
	
}
