package me.xtrm.delta.loader.api.library;

import java.util.List;

public interface ILibraryManager {
	
	void init();
	void loadLibrary(ILibrary library);
	
	List<ILibrary> getLoadedLibraries();

}
