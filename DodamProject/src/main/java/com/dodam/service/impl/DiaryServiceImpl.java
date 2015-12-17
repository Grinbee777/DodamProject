package com.dodam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.dao.DiaryDao;
import com.dodam.service.DiaryService;
import com.dodam.service.domain.Diary;


@Service("diaryServiceImpl")
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	private DiaryDao diaryDao;
	public void setDiaryDao(DiaryDao diaryDao) {
		this.diaryDao = diaryDao;
	}
	
	public DiaryServiceImpl() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

	@Override
	public int insertDiary(Diary diary) throws Exception {
		return diaryDao.insertDiary(diary);
	}

	@Override
	public Diary getDiary(int dNo) throws Exception {
		return diaryDao.getDiary(dNo);
	}

	@Override
	public List<Diary> getDiaryList(int uNo) throws Exception {		
		return diaryDao.getDiaryList(uNo);
	}

	@Override
	public int updateDCode(Diary diary) throws Exception {		
		return diaryDao.updateDCode(diary);
	}

	@Override
	public int updateDiary(Diary diary) throws Exception {
		return diaryDao.updateDiary(diary);
	}

	@Override
	public int deleteDiary(int dNo) throws Exception {		
		return diaryDao.deleteDiary(dNo);
	}
	
	@Override
	public List<Diary> getFriendDiaryList(List friendNo) throws Exception {		
		return diaryDao.getFriendDiaryList(friendNo);
	}

	@Override
	public List<Diary> getDiaryListForCalender(Diary diary) throws Exception {
		return diaryDao.getDiaryListForCalender(diary);
	}
	

}
