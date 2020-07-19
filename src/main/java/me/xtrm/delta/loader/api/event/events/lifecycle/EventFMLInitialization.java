package me.xtrm.delta.loader.api.event.events.lifecycle;

import me.xtrm.delta.loader.api.event.data.Event;
import me.xtrm.delta.loader.api.event.data.EventType;

/**
 * Lifecycle Event
 * 
 * Fired before and after the FMLInitialization Forge Events are fired
 */
public class EventFMLInitialization extends Event {

	/** The current event type */
	private EventType type;
	
	/**
	 * Constructor
	 * @param eventType
	 * 		the relative {@link EventType}
	 */
	public EventFMLInitialization(EventType eventType) {
		this.type = eventType;
	}
	
	/**
	 * @return the current event type
	 */
	public EventType getType() {
		return type;
	}
	
}
