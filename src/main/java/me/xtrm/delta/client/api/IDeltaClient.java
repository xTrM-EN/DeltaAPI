package me.xtrm.delta.client.api;

import me.xtrm.delta.client.api.command.ICommandManager;
import me.xtrm.delta.client.api.file.IFileManager;
import me.xtrm.delta.client.api.module.IModuleManager;
import me.xtrm.delta.client.api.setting.ISettingManager;

/**
 * Base interface for Delta Client
 * @author xTrM_
 */
public interface IDeltaClient {

	/** Get the {@link IFileManager FileManager} */
	IFileManager getFileManager();
	
	/** Get the {@link IModuleManager ModuleManager} */
	IModuleManager getModuleManager();
	
	/** Get the {@link ISettingManager SettingManager} */
	ISettingManager getSettingManager();
	
	/** Get the {@link ICommandManager CommandManager} */
	ICommandManager getCommandManager();

}
