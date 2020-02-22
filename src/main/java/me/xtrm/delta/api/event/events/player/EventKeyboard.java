package me.xtrm.delta.api.event.events.player;

import me.xtrm.atlaspluginloader.core.event.Event;

public class EventKeyboard extends Event {

	private int key;
	
	public EventKeyboard(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return this.key;
	}
	
}
