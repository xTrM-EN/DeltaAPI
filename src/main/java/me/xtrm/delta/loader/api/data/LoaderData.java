package me.xtrm.delta.loader.api.data;

import java.io.InputStream;
import java.util.List;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import me.xtrm.delta.loader.api.IDeltaLoader;

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
	
	/**
	 * @return the loader's main class
	 */
	public String getMainClass() {
		return mainClass;
	}
	
	/**
	 * @return the maven repositories
	 */
	public List<String> getRepositories() {
		return repositories;
	}
	
	/**
	 * @return the required libraries
	 */
	public List<String> getLibraries() {
		return libraries;
	}
	
	/**
	 * @param inputStream
	 * 		the parsable stream
	 * @return the parsed data
	 */
	public static LoaderData parse(InputStream inputStream) {
		Yaml yaml = new Yaml(new Constructor(LoaderData.class));
		return yaml.load(inputStream);
	}

}
