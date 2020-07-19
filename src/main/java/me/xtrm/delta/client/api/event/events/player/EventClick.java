package me.xtrm.delta.client.api.event.events.player;

import me.xtrm.delta.loader.api.event.data.Event;

/**
 * Event fired when the client player clicks 
 * 
 * @author xTrM_
 */
public class EventClick extends Event {
	
	/** The mouse button being pressed */
	private MouseButton mouseButton;
	/** The click type */
	private ClickType clickType;
	
	/**
	 * Constructor
	 * @param mouseButton
	 * 		the mouse button being pressed
	 * @param clickType
	 * 		the click type
	 */
	public EventClick(MouseButton mouseButton, ClickType clickType) {
		this.mouseButton = mouseButton;
		this.clickType = clickType;
	}
	
	/**
	 * @return the mouse button being pressed
	 */
	public MouseButton getMouseButton() {
		return mouseButton;
	}
	
	/**
	 * @return the click type
	 */
	public ClickType getClickType() {
		return clickType;
	}

	/**
	 * Enum of mouse buttons
	 * @author xTrM_
	 */
	public enum MouseButton { LEFT, MIDDLE, RIGHT, OTHER; }
	/**
	 * Enum of click types 
	 * @author NOXW7
	 */
	public enum ClickType { PRESS, RELEASE; }	
	
}
