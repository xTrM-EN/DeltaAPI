package me.xtrm.delta.loader.api.transform;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

public interface ITransformer extends Opcodes {

	default boolean isTarget(String name, boolean isSubclass) {
		return true;
	}
	
	void transform(ClassNode classNode);
	
}
