package me.xtrm.delta.client.api.file;

import java.io.File;
import java.io.IOException;

import com.google.gson.Gson;

public interface ISavedFile {
	
	void saveFile() throws IOException;
	void loadFile() throws IOException;
	
	File getFile();
	Gson getGson();
	
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
