package com.dodam.dao;

import java.util.List;

import com.dodam.service.domain.Replies;

public interface RepliesDao {
	int insertReplies(Replies replies);
	Replies getReplies(int rNo);
	List<Replies> getRepliesList(int dNo);
	int updateReplies(Replies replies);
	//rNo전달시 1개만 삭제 dNo전달시 일괄삭제가능
	int deleteReplies(int rNo);
	
}
