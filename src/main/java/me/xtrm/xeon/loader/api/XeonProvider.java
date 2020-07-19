package me.xtrm.xeon.loader.api;

/**
 * Static provider for {@link IXeonLoader}
 * @author xTrM_
 */
public class XeonProvider {

	/** The primary {@link IXeonLoader} instance */
	private static IXeonLoader xeonLoader;
	
	/** Set {@link xeonLoader} to the current loader */
	static void setupXeonLoader(IXeonLoader xeon) {
		xeonLoader = xeon;
	}
	
	/**
	 * @return the primary {@link IXeonLoader} instance
	 */
	public static IXeonLoader getXeonLoader() {
		return xeonLoader;
	}
	
}