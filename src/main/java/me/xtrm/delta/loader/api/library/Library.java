package me.xtrm.delta.loader.api.library;

/**
 * Simple implementation for {@link ILibrary}
 * @author xTrM_
 */
public class Library implements ILibrary {

	/** The library's declaration */
	private String declaration;
	
	/**
	 * Constructor
	 * @param declaration 
	 * 		the library declaration
	 */
	public Library(String declaration) {
		this.declaration = declaration;
	}
	
	/**
	 * @return the library's declaration 
	 */
	@Override
	public String getLibraryDeclaration() {
		return this.declaration;
	}	
	
}
