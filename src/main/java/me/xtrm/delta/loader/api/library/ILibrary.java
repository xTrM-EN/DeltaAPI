package me.xtrm.delta.loader.api.library;

import java.io.File;
import java.util.regex.Pattern;

public interface ILibrary {

	String getLibraryString();

	default String getGroup() {
		return getLibraryString().split(Pattern.quote(":"))[0];
	}
	
	default String getName() {
		return getLibraryString().split(Pattern.quote(":"))[1];
	}
	
	default String getVersion() {
		return getLibraryString().split(Pattern.quote(":"))[2];
	}
	
	default String getFilePath() {
		return getGroup() 
				+ File.separator 
				+ getName() 
				+ File.separator 
				+ getVersion() 
				+ File.separator 
				+ getName() 
				+ "-" 
				+ getVersion() 
				+ ".jar";
	}
	
}
