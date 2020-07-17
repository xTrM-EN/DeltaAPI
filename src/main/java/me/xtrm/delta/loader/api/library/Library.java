package me.xtrm.delta.loader.api.library;

/**
 * Simple implementation for {@link ILibrary}
 * @author xTrM_
 */
public class Library implements ILibrary {

	/** The library's declaration */
	private String declaration;
	
	/** Constructor */
	public Library(String declaration) {
		this.declaration = declaration;
	}
	
	/** Get the library's declaration */
	@Override
	public String getLibraryString() {
		return this.declaration;
	}	
	
}
