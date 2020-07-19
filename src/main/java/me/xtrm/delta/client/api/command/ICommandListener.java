package me.xtrm.delta.client.api.command;

/**
 * Base interface for any command listeners
 * (Usually implemented by the chat or by the console)
 * @author xTrM_
 */
public interface ICommandListener {
	
	/**
	 * @param text
	 * 		the text to be printed
	 */
	void print(String text);
	
	/** Clears the listeners logs */
	void clear();

}
