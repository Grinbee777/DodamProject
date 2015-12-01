package com.dodam.dao;

import java.util.List;

import com.dodam.service.domain.Diary;


public interface DiaryDao {
	int insert(Diary diary);
	Diary getDiary(int dNo);
	List<Diary> getDiaryList();
	int updateDCode(String dCode);
	int updateDTag(String dTag);
	int deleteDiary(int dNo);
	
}