package me.xtrm.delta.loader.api.event.bus;

public class Priority {
    
	public static final byte HIGHEST = 0, HIGH = 1, NORMAL = 2, LOW = 3, LOWEST = 4;
    private static final byte[] values = new byte[] { 0, 1, 2, 3, 4 };
    
    public static final byte[] values() {
    	return values;
    }
}
