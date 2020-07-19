package me.xtrm.delta.client.api.command;

import net.minecraft.util.EnumChatFormatting;

/**
 * Base interface for any command
 * @author xTrM_
 */
public interface ICommand {

	/**
	 * @return the command's name
	 */
	String getName();
	
	/**
	 * 
	 * @param listener
	 * 		the current listener (either chat or console)
	 * @param args
	 * 		the provided arguments
	 * @return wheather or not the command corretly executed
	 */
	boolean execute(ICommandListener listener, String[] args);
	
	/**
	 * @return the command's description
	 */
	String getDescription();
	
	/**
	 * @return the command's aliases
	 */
	default String[] getAliases() {
		return new String[0];
	}
	
	/**
	 * @return the command's help
	 */
	String getHelp();
	
	/**
	 * Print a message in the listener
	 * @param listener
	 * 		the current listener (either chat or console)
	 * @param msg
	 * 		the message
	 */
	default void printMessage(ICommandListener listener, String msg) { 
		listener.print(EnumChatFormatting.GRAY + msg); 
	}
	
}
