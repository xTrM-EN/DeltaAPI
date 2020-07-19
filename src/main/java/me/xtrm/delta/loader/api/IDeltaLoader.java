package me.xtrm.delta.loader.api;

import java.util.List;

import me.hippo.api.lwjeb.bus.PubSub;
import me.xtrm.delta.loader.api.event.data.IEvent;
import me.xtrm.delta.loader.api.library.ILibraryManager;
import me.xtrm.delta.loader.api.plugin.IPluginManager;
import me.xtrm.xeon.loader.api.IXeonLoader;
import me.xtrm.xeon.loader.api.transform.ITransformer;

/**
 * Base interface for DeltaLoader
 * @author xTrM_
 */
public interface IDeltaLoader {
	
	/** Called after {@link IXeonLoader#postInit(net.minecraft.launchwrapper.LaunchClassLoader)} */
	void initialize();
	
	/** 
	 * @return the main {@link PubSub} 
	 */
	PubSub<IEvent> getEventManager();
	
	/** 
	 * @return the {@link IPluginManager PluginManager} 
	 */
	IPluginManager getPluginManager();
	
	/** 
	 * @return the {@link ILibraryManager LibraryManager} 
	 */
	ILibraryManager getLibraryManager();
	
	/** 
	 * @return the loader's {@link ITransformer Transformers} 
	 */
	List<ITransformer> getTransformers();

}
