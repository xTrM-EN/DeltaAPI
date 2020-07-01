package me.xtrm.delta.client.api.data;

import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class ClientData {
	
	private int dataVersion;
	
	private String mainClass;
	
	private String[] plugins;

	public int getDataVersion() {
		return dataVersion;
	}

	public String getMainClass() {
		return mainClass;
	}

	public String[] getPlugins() {
		return plugins;
	}
	
	public static ClientData parse(InputStream is) {
		Yaml yaml = new Yaml(new Constructor(ClientData.class));
		return yaml.load(is);
	}

}
