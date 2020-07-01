package me.xtrm.delta.loader.api.plugin;

import java.io.File;
import java.util.Map;

import me.xtrm.delta.loader.api.plugin.types.IPlugin;
import me.xtrm.delta.loader.api.plugin.types.PluginInfo;

public interface IPluginManager {
	
	void init(File pluginsDir);
	void loadPlugin(File pluginFile);
	
	boolean isPlugin(File jarFile);
	String getPluginMainClass(File pluginFile);
	
	Map<IPlugin, PluginInfo> getLoadedPlugins();

}
