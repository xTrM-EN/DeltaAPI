package me.xtrm.delta.client.api;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import me.xtrm.delta.client.api.data.ClientData;

public class DeltaAPI {

	private static ClientData data;
	private static IDeltaClient clientInstance;

	public static ClientData getClientData() {
		return data;
	}

	public static IDeltaClient getClient() {
		return clientInstance;
	}

	static {
		InputStream is = DeltaAPI.class.getResourceAsStream("/client_data.json");
		if (is == null)
			throw new Error("/client_data.json file not found!");

		data = ClientData.parse(is);

		try {
			clientInstance = (IDeltaClient) Class.forName(data.getMainClass()).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
