package me.xtrm.delta.client.api.module;

import me.xtrm.delta.client.api.DeltaAPI;
import me.xtrm.delta.client.api.setting.ISetting;

/**
 * Base interface for any module
 * @author xTrM_
 */
public interface IModule {
	
	/** Get the name */
	String getName();
	
	/** Get the displayed name */
	String getDisplayName();
	/** Set the displayed name */
	void setDisplayName(String displayName);
	
	/** Get the description */
	String getDescription();
	/** Set the description */
	void setDescription(String desc);
	
	/** Get the {@link Category} */
	Category getCategory();
	
	/** Get the keybinding */
	int getKey();
	/** Set the keybinding */
	void setKey(int key);
	
	/** Get the animation key */
	int getAnimation();
	/** Set the animation key */
	void setAnimation(int anim);
	
	/** Get the enabled state */
	boolean isEnabled();
	/** Set the enabled state */
	void setEnabled(boolean enabled);
	
	/** Get the visible state */
	boolean isVisible();
	/** Set the visible state */
	void setVisible(boolean visible);
	
	/** Toggle the module */
	void toggle();
	
	/** Called when the module is enabled */
	void onEnable();
	/** Called when the module is toggled */
	void onToggle();
	/** Called when the module is disabled */
	void onDisable();
	
	/** Register settings */
	default void registerSettings(ISetting... settings) {
		DeltaAPI.getClient().getSettingManager().registerSettings(settings);
	}
	/**
	 * @param name
	 * @return this module's setting with that name
	 */
	default ISetting getSetting(String name) {
		return DeltaAPI.getClient().getSettingManager().getSettingByModuleAndName(this, name);
	}

}
