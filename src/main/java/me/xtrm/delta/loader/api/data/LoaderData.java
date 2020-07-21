package me.xtrm.delta.loader.api.data;

import java.io.InputStream;
import java.util.List;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.introspector.BeanAccess;

import me.xtrm.delta.loader.api.IDeltaLoader;

/**
 * Data class for the current {@link IDeltaLoader DeltaLoader}
 * @author xTrM_
 */
public class LoaderData {

	/** The loader's main class */
	public String mainClass;
	
	/** The maven repositories to look through */
	public List<String> repositories;
	/** The required libraries */
	public List<String> libraries;
	
	/**
	 * @return the loader's main class
	 */
	public String getMainClass() {
		return mainClass;
	}
	
	/**
	 * @param mainClass
	 * 		the loader's main class
	 */
	public void setMainClass(String mainClass) {
		if(this.mainClass != null || !this.mainClass.isEmpty()) {
			throw new IllegalStateException("Cannot set main class after it has already been set");
		}
		this.mainClass = mainClass;
	}
	
	/**
	 * @return the maven repositories
	 */
	public List<String> getRepositories() {
		return repositories;
	}
	
	/**
	 * @param repositories
	 * 		the maven repositories
	 */
	public void setRepositories(List<String> repositories) {
		if(this.repositories != null || this.repositories.size() != 0) {
			throw new IllegalStateException("Cannot set repositories after it has already been set");
		}
		this.repositories = repositories;
	}
	
	/**
	 * @return the required libraries
	 */
	public List<String> getLibraries() {
		return libraries;
	}
	
	/**
	 * @param libraries
	 * 		the required libraries
	 */
	public void setLibraries(List<String> libraries) {
		if(this.libraries != null || this.libraries.size() != 0) {
			throw new IllegalStateException("Cannot set libraries after it has already been set");
		}
		this.libraries = libraries;
	}
	
	/**
	 * @param inputStream
	 * 		the parsable stream
	 * @return the parsed data
	 */
	public static LoaderData parse(InputStream inputStream) {
		Yaml yaml = new Yaml(new Constructor(LoaderData.class));
		yaml.setBeanAccess(BeanAccess.FIELD);
		return yaml.load(inputStream);
	}

}
