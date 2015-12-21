package com.dodam.dao;

import java.util.List;

import com.dodam.service.domain.Like;

public interface LikeDao {
	
	int insertLike(Like like);
	Like getLike(int lNo);
	List<Like> getLikeList(int dNo);
	int updateLike(int lNo);
	int deleteLike(Like like);
	int deleteDiaryLike(int dNo);
}
