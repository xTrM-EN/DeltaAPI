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
	 * The plugin's name
	 */
	String name();
	
	/**
	 * The plugin's version
	 */
	String version();
	
	/**
	 * The plugin's author
	 */
	String author();
	
	/**
	 * The plugin's Transformers 
	 */
	Class<? extends ITransformer>[] transformers() default {};
	
}