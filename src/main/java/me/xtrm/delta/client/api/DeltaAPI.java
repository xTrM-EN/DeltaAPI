package me.xtrm.delta.client.api;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import me.xtrm.delta.client.api.data.ClientData;

/**
 * Static provider for {@link IDeltaClient}
 * @author xTrM_
 */
public class DeltaAPI {

	/** Relative data about the current client */
	private static ClientData data;
	/** The primary {@link IDeltaClient} instance */
	private static IDeltaClient clientInstance;

	/** 
	 * @return the current client's data 
	 */
	public static ClientData getClientData() {
		return data;
	}

	/** 
	 * @return the primary {@link IDeltaClient} instance 
	 */
	public static IDeltaClient getClient() {
		return clientInstance;
	}

	static {
		InputStream is = DeltaAPI.class.getResourceAsStream("/client_data.yml");
		if (is == null)
			throw new Error("/client_data.yml file not found!");

		/** Parse the ./client_data.json file */
		data = ClientData.parse(is);

		try {
			/** Create a new IDeltaLoader instance from the parsed data */
			clientInstance = (IDeltaClient) Class.forName(data.getMainClass()).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
