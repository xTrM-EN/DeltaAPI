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
	
	/** 
	 * @return the list of all modules 
	 */
	List<IModule> getModules();
	
	/**
	 * Register modules
	 * @param modules
	 * 		the modules to be registered
	 */
	default void registerModules(IModule... modules) {
		Collections.addAll(getModules(), modules);
	}
	
	/**
	 * @param name
	 * 		the module's name
	 * @return the module with this name
	 */
	default IModule getModule(String name) {
		return getModules().stream().filter(m -> m.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}
	
	/**
	 * @param clazz
	 * 		the module's class
	 * @return the module with this class
	 */
	default IModule getModule(Class<? extends IModule> clazz) {
		return getModules().stream().filter(m -> m.getClass().equals(clazz)).findFirst().orElse(null);
	}
	
	/** 
	 * @param category
	 * 		a module {@link Category}
	 * @return all modules in the {@link Category} 
	 */
	default List<IModule> getModulesInCategory(Category category) {
		return getModules().stream().filter(m -> m.getCategory() == category).collect(Collectors.toList());
	}

}
