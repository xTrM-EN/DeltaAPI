package me.xtrm.delta.loader.api.plugin.exception;

public class PluginLoadingException extends RuntimeException {

	private static final long serialVersionUID = -1042477986930034594L;

	public PluginLoadingException(String message) {
		super(message);
	}
	
	public PluginLoadingException(String message, Throwable cause) {
		super(message, cause);
	}

}
