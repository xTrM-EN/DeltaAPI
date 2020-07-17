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
	 * @param name
	 * @param isSubclass
	 * @return should this transformer be called
	 */
	default boolean isTarget(String name, boolean isSubclass) {
		return true;
	}
	
	/**
	 * Transforms the {@link ClassNode}
	 * @param classNode
	 * @param name
	 */
	void transform(ClassNode classNode, String name);
	
}
