package me.xtrm.delta.client.api.command;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;

public interface ICommand {

	static final Minecraft mc = Minecraft.getMinecraft();
	
	String getName();
	
	boolean execute(ICommandListener listener, String[] args);
	
	String getDescription();
	String[] getAliases();
	String getHelp();
	
	default void printMessage(ICommandListener listener, String msg) { 
		listener.print(EnumChatFormatting.GRAY + msg); 
	}
	
}
