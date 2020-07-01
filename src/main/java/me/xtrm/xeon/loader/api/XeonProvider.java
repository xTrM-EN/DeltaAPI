package me.xtrm.xeon.loader.api;

public class XeonProvider {

	private static IXeonLoader xeonLoader;
	
	static void setupXeonLoader(IXeonLoader xeon) {
		xeonLoader = xeon;
	}
	
	public static IXeonLoader getXeonLoader() {
		return xeonLoader;
	}
	
}
