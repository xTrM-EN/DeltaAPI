package me.xtrm.delta.client.api.data;

import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.introspector.BeanAccess;

import me.xtrm.delta.client.api.IDeltaClient;

/**
 * Data class for the current {@link IDeltaClient Client}
 * @author xTrM_
 */
public class ClientData {
	
	/** The client's main class */
	private String mainClass;
	
	/** The client's internal plugins */
	private String[] plugins;

	/**
	 * @return the main class
	 */
	public String getMainClass() {
		return mainClass;
	}
	
	/**
	 * @param mainClass
	 * 		the client's main class
	 */
	public void setMainClass(String mainClass) {
		if(this.mainClass != null || !this.mainClass.isEmpty()) {
			throw new IllegalStateException("Cannot set main class after it has already been set");
		}
		this.mainClass = mainClass;
	}

	/**
	 * @return the internal plugins
	 */
	public String[] getPlugins() {
		return plugins;
	}
	
	/**
	 * @param plugins
	 * 		the client's internal plugins
	 */
	public void setPlugin(String[] plugins) {
		if(this.plugins != null || this.plugins.length != 0) {
			throw new IllegalStateException("Cannot set plugins after it has already been set");
		}
		this.plugins = plugins;
	}
	
	/**
	 * @param inputStream
	 * 		the parsable stream
	 * @return the parsed data
	 */
	public static ClientData parse(InputStream inputStream) {
		Yaml yaml = new Yaml(new Constructor(ClientData.class));
		yaml.setBeanAccess(BeanAccess.FIELD);
		return yaml.load(inputStream);
	}

}
