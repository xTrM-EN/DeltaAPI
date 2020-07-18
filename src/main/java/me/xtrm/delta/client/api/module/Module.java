package me.xtrm.delta.client.api.module;

import me.xtrm.delta.loader.api.LoaderProvider;

/**
 * Simple implementation for {@link IModule}
 * @author xTrM_
 */
public class Module implements IModule {
	
	/** The name */
	private String name;
	/** The displayed name */
	private String displayName;
	/** The description */
	private String desc;
	/** The keybinding */
	private int key;
	/** The animation key */
	private int anim;
	/** The category */
	private Category category;
	/** The HUD visibility state */
	private boolean visible;
	/** The toggled state */
	private boolean enabled;
	
	public Module(String name, Category category) { this(name, 0, category, false, true); }	
	public Module(String name, Category category, boolean enabled) { this(name, 0, category, enabled, true); }	
	public Module(String name, Category category, boolean enabled, boolean visible) { this(name, 0, category, enabled, visible); }
	public Module(String name, int key, Category category) { this(name, key, category, false, true); }	
	public Module(String name, int key, Category category, boolean enabled) { this(name, key, category, enabled, true); }	
	public Module(String name, int key, Category category, boolean enabled, boolean visible) {
		this.name = this.displayName = name;
		this.key = key;
		this.anim = 0;
		this.category = category;
		this.visible = visible;
		this.enabled = enabled;
		
		if(enabled) {
			iEnable();
		}
	}

	public String getDisplayName() { return displayName; }
	public final void setDisplayName(String displayName) { this.displayName = displayName; }
	public String getDescription() { return desc; }
	public final void setDescription(String s) { this.desc = s; }
	public final int getKey() { return key; }
	public final void setKey(int key) { this.key = key; }
	public int getAnimation() { return anim; }
	public final void setAnimation(int anim) { this.anim = anim; }
	public final boolean isEnabled() { return enabled; }
	public final boolean isToggled() { return enabled; }
	public final boolean getState() { return enabled; }
	public final String getName() { return name; }
	public final Category getCategory() { return category; }
	public final void setVisible(boolean visible) { this.visible = visible; }
	public final boolean isVisible() { return visible; }
	
	public final void setEnabled(boolean enabled) { this.setState(enabled); }
	public final void setToggled(boolean toggled) { this.setState(enabled); }
	
	public final void setState(boolean state) {
		if(state != getState())
			iToggle();
		
		this.enabled = state;
		
		if(state)
			iEnable();
		else
			iDisable();
	}
	
	public final void toggle() {
		iToggle();
		
		boolean next = !this.enabled;
		this.enabled = next;
		
		if(next)
			iEnable();
		else
			iDisable();
	}
	
	public String getMode() {
		return getSetting("Mode") != null ? getSetting("Mode").getComboValue() : "none";
	}
	
	private void iEnable() { 
		LoaderProvider.getLoader().getEventManager().subscribe(this); 
		if(anim == -1) 
			anim = 0; 
		onEnable(); 
	}
	
	private void iDisable() { 
		LoaderProvider.getLoader().getEventManager().unsubscribe(this); 
		onDisable(); 
	}
	
	private void iToggle() { onToggle(); }
	
	public void onEnable() {}
	public void onDisable() {}
	public void onToggle() {}

}
