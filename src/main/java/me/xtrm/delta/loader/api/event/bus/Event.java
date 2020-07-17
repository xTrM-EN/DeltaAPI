package me.xtrm.delta.loader.api.event.bus;

import me.xtrm.delta.loader.api.LoaderProvider;

public class Event implements IEvent {

	private boolean cancelled;
	
	@Override
	public void call() {
		LoaderProvider.getLoader().getEventManager().post(this).dispatch();;
	}

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

}
