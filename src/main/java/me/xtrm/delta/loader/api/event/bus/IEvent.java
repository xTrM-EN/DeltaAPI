package me.xtrm.delta.loader.api.event.bus;

import me.hippo.api.lwjeb.bus.PubSub;
import me.xtrm.delta.loader.api.IDeltaLoader;

/**
 * Base interface for any event fired trough {@link IDeltaLoader#getEventManager()}
 * @author xTrM_
 */
public interface IEvent {
	
	/** Call the event on the main {@link PubSub} */
	void call();
	
	/** 
	 * @return if the event is cancelled
	 */
	boolean isCancelled();
	
	/** Set the cancelled state */
	void setCancelled(boolean cancelled);
	
	/** 
	 * @return if the event is cancellable 
	 */
	default boolean isCancellable() {
		return getClass().getDeclaredAnnotation(Cancellable.class) != null;
	}

}
