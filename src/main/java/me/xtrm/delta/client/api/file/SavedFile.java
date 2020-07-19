package me.xtrm.delta.client.api.file;

import java.io.File;

import com.google.gson.Gson;

/**
 * Base abstract implementation of {@link ISavedFile}
 * @author xTrM_
 */
public abstract class SavedFile implements ISavedFile {
	
	/** The Gson instance */
	private Gson gson;
	/** The File instance */
	private File file;
	
	/**
	 * Constructor
	 * @param gson
	 * 		the gson instance
	 * @param file
	 * 		the file instance
	 */
	public SavedFile(Gson gson, File file) {
		this.gson = gson;
		this.file = file;
	}

	@Override
	public Gson getGson() {
		return gson;
	}
	
	@Override
	public File getFile() {
		return file;
	}

}
