package me.xtrm.delta.loader.api.event.events.lifecycle;

import me.xtrm.delta.loader.api.event.bus.Event;
import me.xtrm.delta.loader.api.event.bus.EventType;

/**
 * Lifecycle Event
 * 
 * Fired before and after the FMLPostInitialization Forge Events are fired
 */
public class EventFMLPostInitialization extends Event {

	/** The current event type */
	private EventType type;
	
	/** Constructor */
	public EventFMLPostInitialization(EventType type) {
		this.type = type;
	}
	
	/**
	 * @return the current event type
	 */
	public EventType getType() {
		return type;
	}
	
}
