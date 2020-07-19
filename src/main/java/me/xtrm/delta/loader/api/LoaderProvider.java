package me.xtrm.delta.loader.api;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import me.xtrm.delta.client.api.DeltaAPI;
import me.xtrm.delta.loader.api.data.LoaderData;

/**
 * Static provider for {@link IDeltaLoader}
 * @author xTrM_
 */
public class LoaderProvider {
	
	/** Relative data about the current loader */
	private static LoaderData data;
	/** The primary {@link IDeltaLoader} instance */
	private static IDeltaLoader loaderInstance;
	
	/**
	 * @return the current loader's data
	 */
	public static LoaderData getLoaderData() {
		return data;
	}
	
	/**
	 * @return the primary {@link IDeltaLoader} instance
	 */
	public static IDeltaLoader getLoader() {
		return loaderInstance;
	}
	
	static {
		InputStream is = DeltaAPI.class.getResourceAsStream("/loader_data.yml");
		if (is == null)
			throw new Error("/loader_data.yml file not found!");

		/** Parse the ./loader_data.json file */
		data = LoaderData.parse(is);

		try {
			/** Create a new IDeltaLoader instance from the parsed data */
			loaderInstance = (IDeltaLoader) Class.forName(data.getMainClass()).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
