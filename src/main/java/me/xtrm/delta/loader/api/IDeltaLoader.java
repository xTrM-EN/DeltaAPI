package me.xtrm.delta.loader.api;

import java.util.List;

import me.hippo.api.lwjeb.bus.PubSub;
import me.xtrm.delta.loader.api.event.bus.IEvent;
import me.xtrm.delta.loader.api.library.ILibraryManager;
import me.xtrm.delta.loader.api.plugin.IPluginManager;
import me.xtrm.xeon.loader.api.IXeonLoader;
import me.xtrm.xeon.loader.api.transform.ITransformer;

/**
 * Base interface for DeltaLoader
 * @author xTrM_
 */
public interface IDeltaLoader {
	
	/** Called on {@link IXeonLoader#postInit(net.minecraft.launchwrapper.LaunchClassLoader)} */
	void initialize();
	
	/** Get the current {@link PubSub} */
	PubSub<IEvent> getEventManager();
	
	/** Get the {@link IPluginManager} */
	IPluginManager getPluginManager();
	/** Get the {@link ILibraryManager} */
	ILibraryManager getLibraryManager();
	
	/** Get the loader's {@link ITransformer Transformers} */
	List<ITransformer> getTransformers();

}
