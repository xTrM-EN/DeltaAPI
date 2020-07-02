package me.xtrm.delta.client.api.setting;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import me.xtrm.delta.client.api.module.IModule;

public interface ISettingManager {
	
	List<ISetting> getSettings();
	
	default void registerSettings(ISetting... settings) {
		Stream.of(settings).forEach(getSettings()::add);
	}
	
	default List<ISetting> getSettingsForModule(IModule mod) {
		return getSettings().stream().filter(s -> s.getParent() == mod).collect(Collectors.toList());
	}
	
	default ISetting getSettingByInternalName(String internal) {
		return getSettings().stream().filter(s -> s.getInternalName().equalsIgnoreCase(internal)).findFirst().orElse(null);
	}
	
	default ISetting getSettingByInternalName(IModule mod, String name) {
		return getSettings().stream().filter(s -> s.getInternalName().equalsIgnoreCase(mod.getName() + "_" + name)).findFirst().orElse(null);
	}

}
