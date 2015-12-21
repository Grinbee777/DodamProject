package com.dodam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.dao.LikeDao;
import com.dodam.service.LikeService;
import com.dodam.service.domain.Like;

@Service("likeServiceImpl")
public class LikeServiceImpl implements LikeService {
	
	@Autowired
	private LikeDao likeDao;
	public LikeServiceImpl(){
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}
	
	@Override
	public int insertLike(Like like) throws Exception {
		return likeDao.insertLike(like);
	}

	@Override
	public Like getLike(int lNo) throws Exception {		
		return likeDao.getLike(lNo);
	}

	@Override
	public List<Like> getLikeList(int dNo) throws Exception {
		return likeDao.getLikeList(dNo);
	}

	@Override
	public int updateLike(int lNo) throws Exception {
		return likeDao.updateLike(lNo);
	}

	@Override
	public int deleteLike(Like like) throws Exception {
		return likeDao.deleteLike(like);
	}
	
	@Override
	public int deleteDiaryLike(int dNo) throws Exception {
		return likeDao.deleteDiaryLike(dNo);
	}

}
