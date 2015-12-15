package com.dodam.service;

import java.util.List;

import com.dodam.service.domain.Replies;

public interface RepliesService {
	
	int insertReplies(Replies replies) throws Exception;
	
	Replies getReplies(int rNo) throws Exception;
	
	List<Replies> getRepliesList(int dNo) throws Exception;
	
	int updateReplies(Replies replies) throws Exception;
	
	int deleteReplies(int rNo) throws Exception;
	
	int deleteDiaryReply(int dNo) throws Exception;
}
