package com.dodam.dao;

import java.util.List;

import com.dodam.service.domain.Feed;

public interface FeedDao {
	int insertFeed(Feed feed);
	Feed getFeed(int fNo);
	List<Feed> getFeedList(int dsNo);
	int updateFeed(Feed feed);
	//fNo전달시 1개만 삭제 dsNo전달시 일괄삭제가능
	int deleteFeed(int no);
	
}
