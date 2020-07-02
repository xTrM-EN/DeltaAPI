package me.xtrm.xeon.loader.api.classloading;

import org.objectweb.asm.ClassWriter;

public interface IXeonClassLoader {

	Class<?> defineClass(ClassWriter classWriter);
	
	void registerTransformers(String... transformerClasses);
	void registerTransformers(Object... transformers);
	
	void enableClassWrapping();
	void disableClassWrapping();
	
}
