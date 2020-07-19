package me.xtrm.delta.client.api.event.events.render;

import me.xtrm.delta.loader.api.event.data.Cancellable;
import me.xtrm.delta.loader.api.event.data.Event;

/**
 * Event fired when text is rendered
 * 
 * @author xTrM_
 */
@Cancellable
public class EventRenderText extends Event {

	/** The text being rendered */
	private String text;
	
	/**
	 * Constructor
	 * @param text
	 * 		the text being rendered
	 */
	public EventRenderText(String text) {
		this.text = text;
	}
	
	/**
	 * @return the text being rendered
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * @param text
	 * 		the text to be rendered
	 */
	public void setText(String text) {
		this.text = text;
	}
	
}
