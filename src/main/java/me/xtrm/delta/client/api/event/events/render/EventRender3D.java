package me.xtrm.delta.client.api.event.events.render;

import me.xtrm.delta.loader.api.event.data.Event;

/**
 * Event fired when the world is rendered
 * 
 * @author xTrM_
 */
public class EventRender3D extends Event {
	
	/** Rendering ticks */
	private float partialTicks;
	
	/**
	 * Constructor
	 * @param partialTicks
	 * 		the rendering ticks
	 */
	public EventRender3D(float partialTicks) {
		this.partialTicks = partialTicks;
	}
	
	/**
	 * @return the rendering ticks
	 */
	public float getPartialTicks() {
		return this.partialTicks;
	}

}
