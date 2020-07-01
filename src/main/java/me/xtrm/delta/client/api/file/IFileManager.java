package me.xtrm.delta.client.api.file;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public interface IFileManager {

	void init();
	void onShutdown();
	
	default void registerFiles(ISavedFile... files) {
		Stream.of(files).forEach(getFiles()::add);
	}
	
	default void saveFiles() throws IOException {
		getFiles().forEach(t -> {
			try {
				t.saveFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	default void loadFiles() throws IOException {
		getFiles().forEach(t -> {
			try {
				t.loadFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	List<ISavedFile> getFiles();
}
