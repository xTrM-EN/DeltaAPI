package me.xtrm.delta.loader.api.event.events.lifecycle;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import me.xtrm.delta.loader.api.event.bus.Event;
import me.xtrm.delta.loader.api.event.bus.EventType;

/**
 * Lifecycle Event
 * 
 * Fired before and after the FMLPreInitialization Forge Events are fired ({@link EventType#PRE} & {@link EventType#POST})
 * Fired for each FMLPreInitialization Forge Event fired ({@link EventType#ON})
 */
public class EventFMLPreInitialization extends Event {

	/** If {@link EventType#ON}, the current event being sent */
	private FMLPreInitializationEvent event;
	/** The current event type */
	private EventType type;
	
	/** Constructor */
	public EventFMLPreInitialization(EventType type, FMLPreInitializationEvent event) {
		this.type = type;
		this.event = event;
	}
	
	/**
	 * @return the current event type
	 */
	public EventType getType() {
		return type;
	}
	
	/**
	 * @return the current event being sent
	 * @throws UnsupportedOperationException if the the current event type isn't {@link EventType#ON}
	 */
	public FMLPreInitializationEvent getFMLEvent() {
		if(type != EventType.ON) {
			throw new UnsupportedOperationException("Cannot get FMLEvent for " + type.name() + " EventType");
		}
		return event;
	}
	
}

