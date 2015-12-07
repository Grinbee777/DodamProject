package com.dodam.service;

import java.util.List;

import com.dodam.service.domain.Friend;

public interface FriendService {
	
	int insertFriend(Friend friend);
	
	Friend getFriend(int frNo);
	
	List<Friend> getFriendList(int fruNo);
	
	List<Friend> getFriendRequestList(int frMate);
	
	int updateFriend(Friend friend);
	
	int deleteFriend(Friend friend);
}
