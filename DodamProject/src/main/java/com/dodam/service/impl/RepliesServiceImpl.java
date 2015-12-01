package com.dodam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.dao.RepliesDao;
import com.dodam.service.RepliesService;
import com.dodam.service.domain.Replies;

@Service("repliesServiceImpl")
public class RepliesServiceImpl implements RepliesService {
	
	@Autowired
	private RepliesDao repliesDao;
	public void setRepliesDao(RepliesDao repliesDao){
		this.repliesDao = repliesDao;
	}
	
	public RepliesServiceImpl() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

	@Override
	public int insertReplies(Replies replies) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Replies getReplies(int rNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Replies> getRepliesList(int dNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateReplies(Replies replies) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReplies(int no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
