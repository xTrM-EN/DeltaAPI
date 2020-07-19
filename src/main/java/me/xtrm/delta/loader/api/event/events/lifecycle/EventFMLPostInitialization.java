package me.xtrm.delta.loader.api.event.events.lifecycle;

import me.xtrm.delta.loader.api.event.data.Event;
import me.xtrm.delta.loader.api.event.data.EventType;

/**
 * Lifecycle Event
 * 
 * Fired before and after the FMLPostInitialization Forge Events are fired
 */
public class EventFMLPostInitialization extends Event {

	/** The current event type */
	private EventType type;
	
	/**
	 * Constructor
	 * @param eventType
	 * 		the relative {@link EventType}
	 */
	public EventFMLPostInitialization(EventType eventType) {
		this.type = eventType;
	}
	
	/**
	 * @return the current event type
	 */
	public EventType getType() {
		return type;
	}
	
}
