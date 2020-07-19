package me.xtrm.delta.loader.api.event.events.plugin;

import me.xtrm.delta.client.api.IDeltaClient;
import me.xtrm.delta.loader.api.event.data.Cancellable;
import me.xtrm.delta.loader.api.event.data.Event;
import me.xtrm.delta.loader.api.plugin.types.PluginInfo;

/**
 * Internal Event
 * 
 * Fired before a plugin is loaded
 * @author xTrM_
 */
@Cancellable
public class EventPluginLoad extends Event {

	/** The plugin's info */
	private PluginInfo pluginInfo;
	/** Is this plugin an internal plugin (loaded by {@link IDeltaClient}) */
	private boolean internalPlugin;
	
	/**
	 * Constructor
	 * @param pluginInfo
	 * 		the plugin's info
	 * @param internalPlugin
	 * 		if the plugin is an internal plugin (loaded by {@link IDeltaClient})
	 */
	public EventPluginLoad(PluginInfo pluginInfo, boolean internalPlugin) {
		this.pluginInfo = pluginInfo;
		this.internalPlugin = internalPlugin;
	}
	
	@Override
	public final void setCancelled(boolean cancelled) {
		/** If this is an internal plugin, its loading cannot be cancelled */
		if(internalPlugin) {
			throw new UnsupportedOperationException("Cannot cancel loading of an internal plugin.");
		}
		super.setCancelled(cancelled);
	}
	
}
