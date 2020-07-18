package me.xtrm.delta.loader.api.data;

import java.io.InputStream;
import java.util.List;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

/**
 * Data class for the current {@link IDeltaLoader DeltaLoader}
 * @author xTrM_
 */
public class LoaderData {

	/** The loader's main class */
	private String mainClass;
	
	/** The maven repositories to look through */
	private List<String> repositories;
	/** The required libraries */
	private List<String> libraries;
	
	public String getMainClass() {
		return mainClass;
	}
	
	public List<String> getRepositories() {
		return repositories;
	}
	
	public List<String> getLibraries() {
		return libraries;
	}
	
	/**
	 * @param inputStream
	 * @return the parsed data
	 */
	public static LoaderData parse(InputStream inputStream) {
		Yaml yaml = new Yaml(new Constructor(LoaderData.class));
		return yaml.load(inputStream);
	}

}
