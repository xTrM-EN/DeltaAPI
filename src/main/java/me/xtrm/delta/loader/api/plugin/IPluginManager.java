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
	
	/**
	 * Initialize the plugin manager
	 * @param pluginsDir 
	 * 		the plugins directory
	 */
	void init(File pluginsDir);
	
	/** 
	 * Load a plugin file
	 * @param pluginFile 
	 * 		the plugin jar file
	 */
	void loadPlugin(File pluginFile);
	
	/**
	 * @param jarFile 
	 * 		a jar file
	 * @return is the jarFile a plugin file
	 */
	boolean isPlugin(File jarFile);
	
	/**
	 * @param pluginFile 
	 * 		a plugin jar file
	 * @return the plugin's main class
	 */
	String getPluginMainClass(File pluginFile);
	
	/**
	 * @return the loaded plugins mapped to their {@link PluginInfo}
	 */
	Map<IPlugin, PluginInfo> getLoadedPlugins();

}
