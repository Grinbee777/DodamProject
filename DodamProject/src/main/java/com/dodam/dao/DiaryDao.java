package com.dodam.dao;

import java.util.List;

import com.dodam.service.domain.Diary;


public interface DiaryDao {
	int insertDiary(Diary diary);
	Diary getDiary(int dNo);
	List<Diary> getDiaryList();
	int updateDCode(String dCode);
	int updateDiary(Diary diary);
	int deleteDiary(int dNo);
	
}