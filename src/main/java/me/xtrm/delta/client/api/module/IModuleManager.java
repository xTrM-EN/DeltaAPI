package me.xtrm.delta.client.api.module;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface IModuleManager {
	
	void init();
	
	List<IModule> getModules();
	
	default void registerModules(IModule... modules) {
		Stream.of(modules).forEach(getModules()::add);
	}
	
	default IModule getModule(String name) {
		return getModules().stream().filter(m -> m.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}
	
	default List<IModule> getModulesInCategory(Category cat){
		return getModules().stream().filter(m -> m.getCategory() == cat).collect(Collectors.toList());
	}

}
