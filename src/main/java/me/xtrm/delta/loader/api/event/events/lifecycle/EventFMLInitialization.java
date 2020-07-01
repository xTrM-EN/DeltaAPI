package me.xtrm.delta.loader.api.event.events.lifecycle;

import me.xtrm.delta.loader.api.event.bus.Event;
import me.xtrm.delta.loader.api.event.bus.EventType;

/**
 * Lifecycle Event
 * 
 * Fired before and after the FMLInitialization Forge Events are fired
 */
public class EventFMLInitialization extends Event {

	private EventType type;
	
	public EventFMLInitialization(EventType type) {
		this.type = type;
	}
	
	public EventType getType() {
		return type;
	}
	
}
