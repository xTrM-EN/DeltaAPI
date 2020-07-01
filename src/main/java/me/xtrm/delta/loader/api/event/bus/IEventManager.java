package me.xtrm.delta.loader.api.event.bus;

public interface IEventManager {
	
	void register(Object... listeners);
	void unregister(Object... listeners);

	void call(IEvent event);
}
