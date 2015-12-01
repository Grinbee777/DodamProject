package com.dodam.service;

import java.util.List;

import com.dodam.service.domain.Feed;

public interface FeedService {
	
	int insertFeed(Feed feed) throws Exception;
	
	Feed getFeed(int fNo) throws Exception;
	
	List<Feed> getFeedList(int dsNo) throws Exception;
	
	int updateFeed(Feed feed) throws Exception;
	
	int deleteFeed(int no) throws Exception;
}
