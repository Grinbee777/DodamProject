package com.dodam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.dao.FeedDao;
import com.dodam.service.FeedService;
import com.dodam.service.domain.Feed;

@Service("feedServiceImpl")
public class FeedServiceImpl implements FeedService {
	
	@Autowired
	private FeedDao feedDao;
	public void setFeedDao(FeedDao feedDao){
		this.feedDao = feedDao;
	}
	
	public FeedServiceImpl() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

	@Override
	public int insertFeed(Feed feed) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Feed getFeed(int fNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feed> getFeedList(int dsNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateFeed(Feed feed) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFeed(int no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
