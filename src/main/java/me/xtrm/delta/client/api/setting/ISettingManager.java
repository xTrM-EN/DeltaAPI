package me.xtrm.delta.client.api.setting;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import me.xtrm.delta.client.api.module.IModule;

/**
 * Base interface for a {@link ISetting} Manager
 * @author xTrM_
 */
public interface ISettingManager {

	/** Get all settings */
	List<ISetting> getSettings();
	
	/** Register settings */
	default void registerSettings(ISetting... settings) {
		Collections.addAll(getSettings(), settings);
	}
	
	/**
	 * @param mod
	 * @return all settings from that module
	 */
	default List<ISetting> getSettingsForModule(IModule mod) {
		return getSettings().stream().filter(s -> s.getParent() == mod).collect(Collectors.toList());
	}
	
	/**
	 * @param internalName
	 * @return the setting with that internal name
	 */
	default ISetting getSettingByInternalName(String internalName) {
		return getSettings().stream().filter(s -> s.getInternalName().equalsIgnoreCase(internalName)).findFirst().orElse(null);
	}
	
	/**
	 * @param module
	 * @param name
	 * @return the setting with that parent and name
	 */
	default ISetting getSettingByModuleAndName(IModule mod, String name) {
		return getSettings().stream().filter(s -> s.getInternalName().equalsIgnoreCase(mod.getName() + "_" + name)).findFirst().orElse(null);
	}

}
