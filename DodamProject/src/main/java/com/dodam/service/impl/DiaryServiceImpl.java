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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Diary> getDiaryList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateDCode(String dCode) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateDTag(String dTag) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDiary(int dNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
