package org.in.dataAccessObj;

import java.util.List;

import org.in.persistanceClzs.Friend;
import org.in.persistanceClzs.User;

public interface FriendDao {
List<User> getAllSuggestedUsers(String email);
List<Friend> pendingRequests(String email);
void friendRequest(Friend friend);
void acceptFriendRequest(Friend friend);
void deleteFriendRequest(Friend friend);
List<User> listOfFriends(String email);
}