package me.xtrm.delta.client.api.event.events.render;

import me.xtrm.delta.loader.api.event.bus.Cancellable;
import me.xtrm.delta.loader.api.event.bus.Event;

@Cancellable
public class EventRenderText extends Event {

	private String text;
	
	public EventRenderText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
}
