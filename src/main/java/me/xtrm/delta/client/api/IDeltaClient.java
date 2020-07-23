package me.xtrm.delta.client.api;

import me.xtrm.delta.client.api.command.ICommandManager;
import me.xtrm.delta.client.api.file.IFileManager;
import me.xtrm.delta.client.api.friend.IFriendManager;
import me.xtrm.delta.client.api.module.IModuleManager;
import me.xtrm.delta.client.api.setting.ISettingManager;

/**
 * Base interface for Delta Client
 * @author xTrM_
 */
public interface IDeltaClient {

	/** 
	 * @return the {@link IFileManager FileManager} 
	 */
	IFileManager getFileManager();
	
	/**
	 * @return the {@link IFriendManager FriendManager}
	 */
	IFriendManager getFriendManager();
	
	/** 
	 * @return the {@link IModuleManager ModuleManager} 
	 */
	IModuleManager getModuleManager();
	
	/** 
	 * @return the {@link ISettingManager SettingManager} 
	 */
	ISettingManager getSettingManager();
	
	/** 
	 * @return the {@link ICommandManager CommandManager} 
	 */
	ICommandManager getCommandManager();

}
