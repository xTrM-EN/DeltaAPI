package me.xtrm.delta.client.api.event.events.player;

import me.xtrm.delta.loader.api.event.bus.Event;

public class EventClick extends Event {
	
	private MouseButton mb;
	private ClickType ct;
	
	public EventClick(MouseButton mb, ClickType ct) {
		this.mb = mb;
		this.ct = ct;
	}
	
	public MouseButton getMouseButton() {
		return mb;
	}
	
	public ClickType getClickType() {
		return ct;
	}
	
	public enum ClickType { PRESS, RELEASE; }	
	public enum MouseButton { LEFT, MIDDLE, RIGHT; }
	
}
