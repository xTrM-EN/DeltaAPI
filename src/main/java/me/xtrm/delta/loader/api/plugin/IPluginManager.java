package me.xtrm.delta.loader.api.plugin;

import java.io.File;
import java.util.Map;

import me.xtrm.delta.loader.api.plugin.types.IPlugin;
import me.xtrm.delta.loader.api.plugin.types.PluginInfo;

/**
 * Base interface for a {@link IPlugin} Manager
 * @author xTrM_
 */
public interface IPluginManager {
	
	/** Initialize the plugin manager */
	void init(File pluginsDir);
	
	/** Load a plugin file */
	void loadPlugin(File pluginFile);
	
	/**
	 * @param jarFile
	 * @return is the jarFile a plugin file
	 */
	boolean isPlugin(File jarFile);
	
	/**
	 * @param pluginFile
	 * @return the plugin's main class
	 */
	String getPluginMainClass(File pluginFile);
	
	/** Get the loaded plugins mapped to their {@link PluginInfo} */
	Map<IPlugin, PluginInfo> getLoadedPlugins();

}
