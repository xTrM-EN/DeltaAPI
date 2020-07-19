package me.xtrm.delta.client.api.module;

import me.xtrm.delta.client.api.DeltaAPI;
import me.xtrm.delta.client.api.setting.ISetting;

/**
 * Base interface for any module
 * @author xTrM_
 */
public interface IModule {
	
	/** 
	 * @return the name 
	 */
	String getName();
	
	/** 
	 * @return the displayed name 
	 */
	String getDisplayName();
	/** 
	 * @param displayName
	 * 		the displayed name 
	 */
	void setDisplayName(String displayName);
	
	/** 
 	 * @return the description 
 	 */
	String getDescription();
	/** 
	 * @param description
	 * 		the description 
	 */
	void setDescription(String description);
	
	/**
	 * @return the {@link Category} 
	 */
	Category getCategory();
	
	/** 
	 * @return the keybinding 
	 */
	int getKey();
	/** 
	 * @param key
	 * 		the keybinding 
	 */
	void setKey(int key);
	
	/** 
	 * @return the animation key 
	 */
	int getAnimation();
	/** @param anim
	 * 		the animation key 
	 */
	void setAnimation(int anim);
	
	/** 
	 * @return the enabled state 
	 */
	boolean isEnabled();
	/** 
	 * @param enabled
	 * 		the enabled state 
	 */
	void setEnabled(boolean enabled);
	
	/** 
 	 * @return the visible state 
 	 */
	boolean isVisible();
	/** 
	 * @param visible
	 * 		the visible state 
	 */
	void setVisible(boolean visible);
	
	/** Toggle the module */
	void toggle();
	
	/** Called when the module is enabled */
	void onEnable();
	/** Called when the module is toggled */
	void onToggle();
	/** Called when the module is disabled */
	void onDisable();
	
	/**
	 * Register settings
	 * @param settings
	 * 		the settings to be registered
	 */
	default void registerSettings(ISetting... settings) {
		DeltaAPI.getClient().getSettingManager().registerSettings(settings);
	}
	/**
	 * @param name
	 * 		the setting's name
	 * @return this module's setting with that name
	 */
	default ISetting getSetting(String name) {
		return DeltaAPI.getClient().getSettingManager().getSettingByModuleAndName(this, name);
	}

}
