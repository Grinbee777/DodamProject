package com.dodam.dao;

import java.util.List;
import java.util.Map;

import com.dodam.service.domain.Diary;


public interface DiaryDao {
	int insertDiary(Diary diary);
	Diary getDiary(int dNo);
	List<Diary> getDiaryList(int uNo);
	int updateDCode(Diary diary);
	int updateDiary(Diary diary);
	int deleteDiary(int dNo);
	List<Diary> getFriendDiaryList(List<Integer> friendNo);
	List<Diary> getDiaryListForCalender(Map<String, Object> map);
	List<Diary> getDailyDiaryList(Diary diary);
	List<Diary> getAllDiary();
	List<Diary> getDiaryListByTag(String dTag);
}