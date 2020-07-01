package me.xtrm.delta.loader.api;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import me.xtrm.delta.client.api.DeltaAPI;
import me.xtrm.delta.loader.api.data.LoaderData;

public class LoaderProvider {
	
	private static LoaderData data;
	private static IDeltaLoader loaderInstance;
	
	public static LoaderData getLoaderData() {
		return data;
	}
	
	public static IDeltaLoader getLoader() {
		return loaderInstance;
	}
	
	static {
		InputStream is = DeltaAPI.class.getResourceAsStream("/loader_data.json");
		if (is == null)
			throw new Error("/loader_data.json file not found!");

		data = LoaderData.parse(is);

		try {
			loaderInstance = (IDeltaLoader) Class.forName(data.getMainClass()).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
