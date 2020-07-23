package me.xtrm.delta.client.api.friend;

import java.util.List;

/**
 * Base interface for a (username based) friend manager
 * @author xTrM_
 */
public interface IFriendManager {

	/**
	 * @return the friend list
	 */
	List<String> getFriends();
	
	/**
	 * Add a friend
	 * @param username
	 * 		the username to be added
	 */
	default void addFriend(String username) {
		if(isFriend(username)) {
			return;
		}
		getFriends().add(username);
	} 
	
	/**
	 * @param username
	 * 		the username to be checked
	 * @return if this username a friend
	 */
	default boolean isFriend(String username) {
		return getFriends().contains(username);
	}
	
	/**
	 * Remove a friend
	 * @param username
	 * 		the username to be removed
	 */
	default void removeFriend(String username) {
		if(isFriend(username)) {
			getFriends().remove(username);
		}
	}
}
