package me.xtrm.delta.client.api.event.events.player;

import me.xtrm.delta.loader.api.event.bus.Event;

public class EventKeyboard extends Event {

	private int key;
	
	public EventKeyboard(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return this.key;
	}
	
}
