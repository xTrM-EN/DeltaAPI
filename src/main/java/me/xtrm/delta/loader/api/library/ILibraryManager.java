package me.xtrm.delta.loader.api.library;

import java.util.List;

/**
 * Base interface for a {@link ILibrary} Manager
 * @author xTrM_
 */
public interface ILibraryManager {
	
	/** Initialize the library manager */
	void init();
	
	/** Load a library */
	void loadLibrary(ILibrary library);
	
	/** Get loaded libraries */
	List<ILibrary> getLoadedLibraries();

}
