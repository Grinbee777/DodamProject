package com.dodam.service;

import java.util.List;

import com.dodam.service.domain.Like;

public interface LikeService {
	
	int insertLike(Like like)throws Exception;
	
	Like getLike(int lNo)throws Exception;
	
	List<Like> getLikeList(int dNo)throws Exception;
	
	int updateLike(int lNo)throws Exception;
	
	int deleteLike(Like like)throws Exception;
	
	int deleteDiaryLike(int dNo)throws Exception;
	
}
