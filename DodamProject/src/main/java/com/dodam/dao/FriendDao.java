package com.dodam.dao;

import java.util.List;

import com.dodam.service.domain.Friend;

public interface FriendDao {
	int insertFriend(Friend friend);
	Friend getFriend(int frNo);
	List<Friend> getFriendList(int uNo);
	List<Friend> getRelationList(int uNo);
	List<Friend> getFriendRequestList(int uNo);
	int updateFriend(Friend friend);
	int deleteFriend(Friend friend);
}
