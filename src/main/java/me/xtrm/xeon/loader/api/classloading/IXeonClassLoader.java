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

	/** Add an URL to the current classpath */
	void addURL(URL url);

	/**
	 * Define a {@link Class} from a {@link ClassWriter}
	 * @param classWriter
	 * @return the defined class
	 */
	Class<?> defineClass(ClassWriter classWriter);

	/** Register multiple {@link ITransformer Transformers} */
	void registerTransformers(ITransformer... transformers);

	/** Get the current {@link ITransformer Transformers} */
	List<ITransformer> getTransformers();

	/** Get if class wrapping enabled */
	boolean isClassWrappingEnabled();
	/** Set the context's class wrapping state */
	void setClassWrapping(boolean state);

}
