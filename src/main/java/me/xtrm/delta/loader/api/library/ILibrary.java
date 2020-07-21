package me.xtrm.delta.loader.api.library;

import java.util.regex.Pattern;

/**
 * Base interface for a Maven Library
 * @author xTrM_
 */
public interface ILibrary {

	/**
	 * @return the library declaration
	 */
	String getLibraryDeclaration();

	/**
	 * @return the library's group
	 */
	default String getGroup() {
		return getLibraryDeclaration().split(Pattern.quote(":"))[0];
	}
	
	/**
	 * @return the library's name
	 */
	default String getName() {
		return getLibraryDeclaration().split(Pattern.quote(":"))[1];
	}
	
	/**
	 * @return the library's name
	 */
	default String getVersion() {
		return getLibraryDeclaration().split(Pattern.quote(":"))[2];
	}
	
	/**
	 * @return a library's path
	 */
	default String getFilePath() {
		return getGroup().replace('.', '/')
				+ "/"
				+ getName() 
				+ "/" 
				+ getVersion() 
				+ "/" 
				+ getName() 
				+ "-" 
				+ getVersion() 
				+ ".jar";
	}
	
}
