package com.dodam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.dao.FriendDao;
import com.dodam.service.FriendService;
import com.dodam.service.domain.Friend;

@Service("friendServiceImpl")
public class FriendServiceImpl implements FriendService {
	
	@Autowired
	private FriendDao friendDao;
	public void setFriendDao(FriendDao friendDao){
		this.friendDao = friendDao;
	}
	
	public FriendServiceImpl() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

	@Override
	public int insertFriend(Friend friend) {
		return friendDao.insertFriend(friend);
	}

	@Override
	public Friend getFriend(int frNo) {
		// TODO Auto-generated method stub
		return friendDao.getFriend(frNo);
	}

	@Override
	public List<Friend> getFriendList(int fruNo) {
		// TODO Auto-generated method stub
		return friendDao.getFriendList(fruNo);
	}

	@Override
	public List<Friend> getFriendRequestList(int frMate) {
		// TODO Auto-generated method stub
		return friendDao.getFriendRequestList(frMate);
	}

	@Override
	public int updateFriend(Friend friend) {
		// TODO Auto-generated method stub
		return friendDao.updateFriend(friend);
	}

	@Override
	public int deleteFriend(Friend friend) {
		// TODO Auto-generated method stub
		return friendDao.deleteFriend(friend);
	}

}
