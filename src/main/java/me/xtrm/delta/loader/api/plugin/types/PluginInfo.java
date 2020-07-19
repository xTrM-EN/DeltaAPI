package me.xtrm.delta.loader.api.plugin.types;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import me.xtrm.xeon.loader.api.transform.ITransformer;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.TYPE)
public @interface PluginInfo {
	
	/**
	 * @return the plugin's name
	 */
	String name();
	
	/**
	 * @return the plugin's version
	 */
	String version();
	
	/**
	 * @return the plugin's author
	 */
	String author();
	
	/**
	 * @return the plugin's Transformers 
	 */
	Class<? extends ITransformer>[] transformers() default {};
	
}