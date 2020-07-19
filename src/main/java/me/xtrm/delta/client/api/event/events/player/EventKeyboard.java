package me.xtrm.delta.client.api.event.events.player;

import me.xtrm.delta.loader.api.event.data.Event;

/**
 * Event fired when a key is pressed 
 * 
 * @author xTrM_
 */
public class EventKeyboard extends Event {

	/** The key being pressed */
	private int key;
	
	/**
	 * Constructor
	 * @param key
	 * 		the key being pressed
	 */
	public EventKeyboard(int key) {
		this.key = key;
	}
	
	/**
	 * @return the key being pressed
	 */
	public int getKey() {
		return this.key;
	}
	
}
