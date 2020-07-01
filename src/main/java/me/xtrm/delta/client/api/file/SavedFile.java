package me.xtrm.delta.client.api.file;

import java.io.File;

import com.google.gson.Gson;

public abstract class SavedFile implements ISavedFile {
	
	private Gson gson;
	private File file;
	
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
