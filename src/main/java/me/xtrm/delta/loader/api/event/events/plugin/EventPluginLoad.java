package me.xtrm.delta.loader.api.event.events.plugin;

import me.xtrm.delta.loader.api.event.bus.Cancellable;
import me.xtrm.delta.loader.api.event.bus.Event;
import me.xtrm.delta.loader.api.plugin.types.PluginInfo;

@Cancellable
public class EventPluginLoad extends Event {

	private PluginInfo pluginInfo;
	private boolean internalPlugin;
	
	public EventPluginLoad(PluginInfo info, boolean internalPlugin) {
		this.pluginInfo = info;
		this.internalPlugin = internalPlugin;
	}
	
	@Override
	public void setCancelled(boolean cancelled) {
		if(internalPlugin) {
			throw new UnsupportedOperationException("Cannot cancel loading of an internal plugin.");
		}
		super.setCancelled(cancelled);
	}
	
}
