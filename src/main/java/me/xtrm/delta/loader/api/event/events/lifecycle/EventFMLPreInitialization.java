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

	private FMLPreInitializationEvent event;
	private EventType type;
	
	public EventFMLPreInitialization(EventType type, FMLPreInitializationEvent event) {
		this.type = type;
		this.event = event;
	}
	
	public EventType getType() {
		return type;
	}
	
	public FMLPreInitializationEvent getFMLEvent() {
		if(type != EventType.ON)
			throw new UnsupportedOperationException("Cannot get FMLEvent for " + type.name() + " event");
		return event;
	}
	
}

