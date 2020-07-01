package me.xtrm.xeon.loader.api;

import java.io.File;
import java.util.List;

import me.xtrm.xeon.loader.api.classloading.IXeonClassLoader;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

public interface IXeonLoader extends ITweaker {

	void init(List<String> launchArgs, File gameDir);
	void setupClassloader(LaunchClassLoader launchClassLoader);
	
	IXeonClassLoader getXeonClassLoader();
	
	@Override
	default void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
		XeonProvider.setupXeonLoader(this);
		init(args, gameDir);
	}
	
	@Override
	default void injectIntoClassLoader(LaunchClassLoader classLoader) {
		setupClassloader(classLoader);
	}
	
	@Override
	default String getLaunchTarget() {
		throw new UnsupportedOperationException("We shouldn't be getting here... HELP");
	}
	
	@Override
	default String[] getLaunchArguments() {
		return new String[0];
	}
	
}
