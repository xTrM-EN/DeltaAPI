package me.xtrm.delta.loader.api;

import me.xtrm.delta.loader.api.event.bus.IEventManager;
import me.xtrm.delta.loader.api.library.ILibraryManager;
import me.xtrm.delta.loader.api.plugin.IPluginManager;
import me.xtrm.delta.loader.api.transform.ITransformerManager;

public interface IDeltaLoader {
	
	void initialize();
	
	IEventManager getEventManager();
	IPluginManager getPluginManager();
	ILibraryManager getLibraryManager();
	ITransformerManager getTransformerManager();

}
