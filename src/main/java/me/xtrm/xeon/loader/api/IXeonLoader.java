package me.xtrm.xeon.loader.api;

import java.io.File;
import java.util.List;

import me.xtrm.xeon.loader.api.classloading.IXeonClassLoader;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

/**
 * Base interface for XeonLoader
 * @author xTrM_
 */
public interface IXeonLoader extends ITweaker {

	/**
	 * Called on tweaker's initialization
	 * @param launchArgs
	 * @param gameDir
	 */
	void init(List<String> launchArgs, File gameDir);
	
	/**
	 * Called after {@link init} 
	 * @param launchClassLoader
	 */
	void postInit(LaunchClassLoader launchClassLoader);
	
	/** Gets the {@link IXeonClassLoader} instance */
	IXeonClassLoader getXCL();
	/** Gets the {@link LaunchClassLoader} instance */
	LaunchClassLoader getWCL();
	
	@Override
	default void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
		XeonProvider.setupXeonLoader(this);
		
		init(args, gameDir);
	}
	
	@Override
	default void injectIntoClassLoader(LaunchClassLoader classLoader) {
		postInit(classLoader);
	}
	
	@Override
	default String getLaunchTarget() {
		/** LaunchWrapper shouldn't call this because we aren't the primary tweaker */
		throw new UnsupportedOperationException("We shouldn't be getting here... HELP");
	}
	
	@Override
	default String[] getLaunchArguments() {
		/** We don't need more game arguments */
		return new String[0];
	}
	
}
