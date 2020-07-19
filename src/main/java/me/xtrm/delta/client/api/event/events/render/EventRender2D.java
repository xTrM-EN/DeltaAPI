package me.xtrm.delta.client.api.event.events.render;

import me.xtrm.delta.loader.api.event.data.Event;

/**
 * Event fired when the interface is drawn
 * 
 * @author xTrM_
 */
public class EventRender2D extends Event {
	
	/** Rendering ticks */
	private float partialTicks;
	
	/**
	 * Constructor
	 * @param partialTicks
	 * 		the rendering ticks
	 */
	public EventRender2D(float partialTicks) {
		this.partialTicks = partialTicks;
	}
	
	/**
	 * @return the rendering ticks
	 */
	public float getPartialTicks() {
		return this.partialTicks;
	}

}
