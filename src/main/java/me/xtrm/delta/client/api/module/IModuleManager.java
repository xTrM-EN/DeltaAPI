package me.xtrm.delta.client.api.module;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Base interface for a {@link IModule} Manager
 * @author xTrM_
 */
public interface IModuleManager {
	
	/** Initialize the manager */
	void init();
	
	/** Get all modules */
	List<IModule> getModules();
	
	/** Register modules */
	default void registerModules(IModule... modules) {
		Collections.addAll(getModules(), modules);
	}
	
	/** Get a module by name */
	default IModule getModule(String name) {
		return getModules().stream().filter(m -> m.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}
	
	/** Get a module by class */
	default IModule getModule(Class<? extends IModule> cla$$) {
		return getModules().stream().filter(m -> m.getClass().equals(cla$$)).findFirst().orElse(null);
	}
	
	/** Get all modules in a {@link Category} */
	default List<IModule> getModulesInCategory(Category cat) {
		return getModules().stream().filter(m -> m.getCategory() == cat).collect(Collectors.toList());
	}

}
