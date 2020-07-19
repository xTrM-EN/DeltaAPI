package me.xtrm.delta.loader.api.event.data;

import me.xtrm.delta.loader.api.LoaderProvider;

/**
 * Simple implementation for {@link IEvent}
 * @author xTrM_
 */
public class Event implements IEvent {

	/** Wheather or not the event is cancelled */
	private boolean cancelled;
	
	@Override
	public final void call() {
		LoaderProvider.getLoader().getEventManager().post(this).dispatch();;
	}

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	/**
	 * @param cancelled
	 * 		if the event is cancelled
	 * @throws UnsupportedOperationException
	 * 		if the event class doesn't implement {@link Cancellable}
	 */
	@Override
	public void setCancelled(boolean cancelled) {
		if(!isCancellable()) {
			throw new UnsupportedOperationException("Cannot cancel event " + getClass().getSimpleName() + " as it doesn't implement @Cancellable");
		}
		this.cancelled = cancelled;
	}

}
