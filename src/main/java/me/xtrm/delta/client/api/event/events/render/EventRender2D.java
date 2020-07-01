package me.xtrm.delta.client.api.event.events.render;

import me.xtrm.delta.loader.api.event.bus.Event;

public class EventRender2D extends Event {
	
	private float partialTicks;
	
	public EventRender2D(float partialTicks) {
		this.partialTicks = partialTicks;
	}
	
	public float getPartialTicks() {
		return this.partialTicks;
	}

}
