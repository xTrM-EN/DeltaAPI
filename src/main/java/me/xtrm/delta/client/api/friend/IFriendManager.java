package me.xtrm.delta.client.api.friend;

import java.util.List;

public interface IFriendManager {

	List<String> getFriends();
	
	default void addFriend(String username) {
		if(isFriend(username)) {
			return;
		}
		getFriends().add(username);
	}
	
	default boolean isFriend(String username) {
		return getFriends().contains(username);
	}
	
	default void removeFriend(String username) {
		if(isFriend(username)) {
			getFriends().remove(username);
		}
	}
	
}
