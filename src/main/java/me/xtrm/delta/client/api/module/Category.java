package me.xtrm.delta.client.api.module;

/**
 * Enum for the module categories
 * @author xTrM_
 */
public enum Category { 
	COMBAT("Combat"), 
	MOVEMENT("Movement"),
	PLAYER("Player"), 
	RENDER("Render"), 
	WORLD("World"), 
	MISC("Misc"), 
	HIDDEN("Hidden", false);
	
	/** The name */
	private String name;
	/** Is this category visible in the ClickGUI */
	private boolean visible;
	
	/**
	 * Constructor
	 * @param name
	 */
	private Category(String name) { this(name, true); }
	/**
	 * Constructor
	 * @param name
	 * @param visible
	 */
	private Category(String name, boolean visible) {
		this.name = name;
		this.visible = visible;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return if this category is visible on the ClickGUI
	 */
	public boolean isVisible() {
		return visible;
	}
}