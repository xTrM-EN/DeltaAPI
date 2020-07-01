package me.xtrm.delta.loader.api.event.events.lifecycle;

import me.xtrm.delta.loader.api.event.bus.Event;
import me.xtrm.delta.loader.api.event.bus.EventType;

/**
 * Lifecycle Event
 * 
 * Fired before and after the FMLPostInitialization Forge Events are fired
 */
public class EventFMLPostInitialization extends Event {

	private EventType type;
	
	public EventFMLPostInitialization(EventType type) {
		this.type = type;
	}
	
	public EventType getType() {
		return type;
	}
	
}
