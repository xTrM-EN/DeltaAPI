package me.xtrm.xeon.loader.api.transform;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

/**
 * Simple Class Transformer
 * @author xTrM_
 */
@FunctionalInterface
public interface ITransformer extends Opcodes {

	/**
	 * @param className
	 * 		the class name
	 * @param isSubclass
	 * 		is the class a subclass
	 * @return should this transformer be called
	 */
	default boolean isTarget(String className, boolean isSubclass) {
		return true;
	}
	
	/**
	 * Transforms the {@link ClassNode}
	 * @param classNode
	 * 		the passed class node
	 * @param className
	 * 		the class name
	 */
	void transform(ClassNode classNode, String className);
	
}
