package me.xtrm.delta.client.api.file;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

/**
 * Base interface for a {@link ISavedFile File} Manager
 * @author xTrM_
 */
public interface IFileManager {

	/** Initialize the manager */
	void init();
	/** Shutdown the manager */
	void onShutdown();
	
	/**
	 * Register files
	 * @param files
	 * 		the savable files to be registered
	 */
	default void registerFiles(ISavedFile... files) {
		Stream.of(files).forEach(getFiles()::add);
	}
	
	/**
	 * Save all files
	 */
	default void saveFiles() {
		getFiles().forEach(t -> {
			try {
				t.saveFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	/**
	 * Load all files 
	 */
	default void loadFiles() {
		getFiles().forEach(t -> {
			try {
				t.loadFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	/**
	 * @return the list of files
	 */
	List<ISavedFile> getFiles();
}
