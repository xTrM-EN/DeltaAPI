package me.xtrm.delta.client.api.data;

import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

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
	 * @return the internal plugins
	 */
	public String[] getPlugins() {
		return plugins;
	}
	
	/**
	 * @param inputStream
	 * 		the parsable stream
	 * @return the parsed data
	 */
	public static ClientData parse(InputStream inputStream) {
		Yaml yaml = new Yaml(new Constructor(ClientData.class));
		return yaml.load(inputStream);
	}

}
