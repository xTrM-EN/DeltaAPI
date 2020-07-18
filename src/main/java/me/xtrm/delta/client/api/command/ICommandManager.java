package me.xtrm.delta.client.api.command;

import java.util.Collections;
import java.util.List;

public interface ICommandManager {
	
	void init();
	
	List<ICommand> getCommands();
	
	default void registerCommands(ICommand... commands) {
		Collections.addAll(getCommands(), commands);
	}
	
	void runCommand(ICommandListener commandListener, String msg);

}
