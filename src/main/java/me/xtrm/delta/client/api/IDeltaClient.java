package me.xtrm.delta.client.api;

import me.xtrm.delta.client.api.command.ICommandManager;
import me.xtrm.delta.client.api.file.IFileManager;
import me.xtrm.delta.client.api.module.IModuleManager;
import me.xtrm.delta.client.api.setting.ISettingManager;

public interface IDeltaClient {
	
	void onInit();
	void onShutdown();
	
	IFileManager getFileManager();
	IModuleManager getModuleManager();
	ISettingManager getSettingManager();
	ICommandManager getCommandManager();

}
