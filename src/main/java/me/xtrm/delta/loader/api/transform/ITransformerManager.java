package me.xtrm.delta.loader.api.transform;

import java.util.List;
import java.util.stream.Stream;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

import net.minecraft.launchwrapper.IClassTransformer;

public interface ITransformerManager extends IClassTransformer {
	
	void initialize();
	
	default void registerTransformers(ITransformer... transformers) {
		Stream.of(transformers).forEach(getTransformers()::add);
	}
	
	List<ITransformer> getTransformers();
	
	@Override
	default byte[] transform(String name, String transformedName, byte[] basicClass) {
		Stream<ITransformer> stream = getTransformers().stream();
		boolean sub = transformedName.contains("$");
		if(!stream.anyMatch(t -> t.isTarget(transformedName, sub))){
			return basicClass;
		}
		
		ClassNode node = new ClassNode(Opcodes.ASM5);
		ClassReader cr = new ClassReader(basicClass);
		cr.accept(node, 0);
		
		stream.filter(t -> t.isTarget(transformedName, sub)).forEach(t -> t.transform(node));
		
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
		node.accept(cw);
		return cw.toByteArray();
	}

}
