package com.dodam.service;

import java.util.List;

import com.dodam.service.domain.Friend;

public interface FriendService {
	
	int insertFriend(Friend friend);
	
	Friend getFriend(int frNo);
	
	List<Friend> getFriendList(int uNo);
	
	List<Friend> getRelationList(int uNo);
	
	List<Friend> getFriendRequestList(int uNo);
	
	List<Friend> getFriendDenyList(int uNo);
	
	int updateFriend(Friend friend);
	
	int deleteFriend(Friend friend);
}
