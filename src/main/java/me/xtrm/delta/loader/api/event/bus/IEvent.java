package me.xtrm.delta.loader.api.event.bus;

public interface IEvent {
	
	void call();
	
	boolean isCancelled();
	void setCancelled(boolean cancelled);
	
	default boolean isCancellable() {
		return getClass().getDeclaredAnnotation(Cancellable.class) != null;
	}

}
