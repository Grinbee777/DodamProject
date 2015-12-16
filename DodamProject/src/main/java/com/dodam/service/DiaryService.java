package com.dodam.service;

import java.util.List;

import com.dodam.service.domain.Diary;

public interface DiaryService {
	
	int insertDiary(Diary diary) throws Exception;
	
	Diary getDiary(int dNo) throws Exception;
	
	List<Diary> getDiaryList(int uNo) throws Exception;
	
	int updateDCode(Diary diary) throws Exception;
	
	int updateDiary(Diary diary) throws Exception;
	
	int deleteDiary(int dNo) throws Exception;
	
	List<Diary> getFriendDiaryList(List<Integer> friendNo) throws Exception;

}
