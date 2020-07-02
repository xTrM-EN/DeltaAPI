package me.xtrm.delta.client.api.module;

public enum Category { 
	COMBAT("Combat"), 
	MOVEMENT("Movement"),
	PLAYER("Player"), 
	RENDER("Render"), 
	WORLD("World"), 
	MISC("Misc"), 
	HIDDEN("Hidden", true);
	
	private String name;
	private boolean visible;
	
	private Category(String name) { this(name, true); }
	private Category(String name, boolean visible) {
		this.name = name;
		this.visible = visible;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isVisible() {
		return visible;
	}
}