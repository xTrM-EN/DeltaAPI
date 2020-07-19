package me.xtrm.xeon.loader.api.classloading;

import java.net.URL;
import java.util.List;

import org.objectweb.asm.ClassWriter;

import me.xtrm.xeon.loader.api.transform.ITransformer;

/**
 * Interface for Xeon's {@link ClassLoader}
 * @author xTrM_
 */
public interface IXeonClassLoader {

	/**
	 * @param url 
	 * 		the url to be added to the classpath
	 */
	void addURL(URL url);

	/**
	 * Define a {@link Class} from a {@link ClassWriter}
	 * @param classWriter
	 * 		a not-empty classwriter
	 * @return the defined class
	 */
	Class<?> defineClass(ClassWriter classWriter);

	/**
	 * Register multiple {@link ITransformer Transformers}
	 * @param transformers
	 * 		the transformers to be registered
	 */
	void registerTransformers(ITransformer... transformers);

	/**
	 * @return the current {@link ITransformer Transformers}
	 */
	List<ITransformer> getTransformers();

	/** 
	 * @return if class wrapping enabled 
	 */
	boolean isClassWrappingEnabled();
	
	/**
	 * @param state 
	 * 		the new class wrapping state
	 */
	void setClassWrapping(boolean state);

}
