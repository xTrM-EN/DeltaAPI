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

	/** 
	 * @return the list of all settings 
	 */
	List<ISetting> getSettings();
	
	/** 
	 * Register settings
	 * @param settings 
	 * 		the settings to be registered
	 */
	default void registerSettings(ISetting... settings) {
		Collections.addAll(getSettings(), settings);
	}
	
	/**
	 * @param module
	 * 		the parent module
	 * @return all settings from that module
	 */
	default List<ISetting> getSettingsForModule(IModule module) {
		return getSettings().stream().filter(s -> s.getParent() == module).collect(Collectors.toList());
	}
	
	/**
	 * @param internalName
	 * 		the internal name of that setting <br>
	 * 		<code>(parentModule.name + "_" + setting.name)</code>
	 * @return the setting with that internal name
	 */
	default ISetting getSettingByInternalName(String internalName) {
		return getSettings().stream().filter(s -> s.getInternalName().equalsIgnoreCase(internalName)).findFirst().orElse(null);
	}
	
	/**
	 * @param module
	 * 		the parent module
	 * @param name
	 * 		the setting's name
	 * @return the setting with that parent and name
	 */
	default ISetting getSettingByModuleAndName(IModule module, String name) {
		return getSettings().stream().filter(s -> s.getInternalName().equalsIgnoreCase(module.getName() + "_" + name)).findFirst().orElse(null);
	}

}
