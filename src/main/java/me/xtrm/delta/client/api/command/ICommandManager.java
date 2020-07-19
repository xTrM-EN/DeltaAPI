package me.xtrm.delta.client.api.command;

import java.util.Collections;
import java.util.List;

/**
 * Base interface for a {@link ICommand Command} Manager
 * @author xTrM_
 */
public interface ICommandManager {
	
	/** Initialize the manager */
	void init();
	
	/**
	 * @return the list of commands
	 */
	List<ICommand> getCommands();
	
	/**
	 * Register commands
	 * @param commands
	 * 		commands to be registered
	 */
	default void registerCommands(ICommand... commands) {
		Collections.addAll(getCommands(), commands);
	}
	
	/**
	 * @param commandListener
	 * 		the current listener (either chat or console)
	 * @param msg
	 * 		the message to be parsed
	 */
	void runCommand(ICommandListener commandListener, String msg);

}
