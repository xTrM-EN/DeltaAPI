package me.xtrm.delta.client.api.command;

import java.util.List;
import java.util.stream.Stream;

import net.minecraft.util.EnumChatFormatting;

public interface ICommandManager {
	
	void init();
	
	List<ICommand> getCommands();
	
	default void registerCommands(ICommand... commands) {
		Stream.of(commands).forEach(getCommands()::add);
	}
	
	default void runCommand(ICommandListener panel, String msg) {
		panel.print(EnumChatFormatting.GRAY + "> " + msg);
		
		if(msg.equalsIgnoreCase("clear") || msg.equalsIgnoreCase("cls")) {
			panel.clear();
			return;
		}
		
		boolean commandResolved = false;
		String readString = msg.trim();
		boolean hasArgs = readString.trim().contains(" ");
		String commandName = hasArgs ? readString.split(" ")[0] : readString.trim();
		String[] args = hasArgs ? readString.substring(commandName.length()).trim().split(" ") : new String[0];
		
		for(ICommand command : getCommands()){
			if(command.getName().trim().equalsIgnoreCase(commandName.trim())) {
				commandResolved = true;
				if(!command.execute(panel, args)) {
					panel.print(EnumChatFormatting.RED + "Une erreur s'est produite durant l'execution.");
				}
				break;
			}
			
			for(String alias : command.getAliases()) {
				if(alias.trim().equalsIgnoreCase(commandName.trim())) {
					commandResolved = true;
					if(!command.execute(panel, args)) {
						panel.print(EnumChatFormatting.RED + "Une erreur s'est produite durant l'execution.");
					}
					break;
				}
			}
			if(commandResolved)
				break;
		}
		if(!commandResolved) {
			panel.print(EnumChatFormatting.RED + "Commande inconnue.");
			panel.print(EnumChatFormatting.RED + "Tapez " + EnumChatFormatting.GOLD + "\"help\" " + EnumChatFormatting.RED + "pour l'aide");
		}
	}

}
