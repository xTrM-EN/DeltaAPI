package me.xtrm.delta.loader.api.library;

public class Library implements ILibrary {

	private String declaration;
	
	public Library(String declaration) {
		this.declaration = declaration;
	}
	
	@Override
	public String getLibraryString() {
		return this.declaration;
	}	
	
}
