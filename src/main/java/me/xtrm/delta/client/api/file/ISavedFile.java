package me.xtrm.delta.client.api.file;

import java.io.File;
import java.io.IOException;

import com.google.gson.Gson;

/**
 * Base interface for a savable {@link File}
 * 
 * @author xTrM_
 */
public interface ISavedFile {
	
	/**
	 * Save the file
	 * @throws IOException
	 *		if saving the file goes wrong
	 */
	void saveFile() throws IOException;
	
	/**
	 * Load the file
	 * @throws IOException
	 * 		if loading the file goes wrong
	 */
	void loadFile() throws IOException;
	
	/**
	 * @return the {@link File} instance
	 */
	File getFile();
	
	/**
	 * @return the {@link Gson} instance
	 */
	Gson getGson();
	
	/**
	 * Create the file/folder
	 * @throws IOException
	 * 		if the file cannot be created
	 */
	default void createFile() throws IOException {
		if(getFile() != null && !getFile().exists()) {
			if(getFile().isDirectory()) {
				getFile().mkdirs();
			}else {
				getFile().getParentFile().mkdirs();
				getFile().createNewFile();
			}
		}			
	}

}
