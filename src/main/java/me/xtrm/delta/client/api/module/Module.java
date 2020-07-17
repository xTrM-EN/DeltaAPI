package me.xtrm.delta.client.api.module;

import me.xtrm.delta.client.api.DeltaAPI;
import me.xtrm.delta.client.api.setting.ISetting;
import me.xtrm.delta.loader.api.LoaderProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class Module implements IModule {
	
	protected Minecraft mc = Minecraft.getMinecraft();
	protected FontRenderer fr = Minecraft.getMinecraft().fontRenderer;
	
	private String name, displayName, desc;
	private int key, anim;
	private Category category;
	private boolean visible, enabled;
	
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
	public void setDisplayName(String displayName) { this.displayName = displayName; }
	public String getDescription() { return desc; }
	public void setDescription(String s) { this.desc = s; }
	public int getKey() { return key; }
	public void setKey(int key) { this.key = key; }
	public int getAnim() { return anim; }
	public void setAnim(int anim) { this.anim = anim; }
	public boolean isEnabled() { return enabled; }
	public boolean isToggled() { return enabled; }
	public boolean getState() { return enabled; }
	public String getName() { return name; }
	public Category getCategory() { return category; }
	public void setVisible(boolean visible) { this.visible = visible; }
	public boolean isVisible() { return visible; }
	
	public void setEnabled(boolean enabled) { this.setToggled(enabled); }
	public void setToggled(boolean toggled) { this.setState(enabled); }
	
	public void setState(boolean state) {
		if(state != getState())
			iToggle();
		
		this.enabled = state;
		
		if(state)
			iEnable();
		else
			iDisable();
	}
	
	public void toggle() {
		iToggle();
		
		boolean next = !this.enabled;
		this.enabled = next;
		
		if(next)
			iEnable();
		else
			iDisable();
	}

	public void registerSettings(ISetting... settings) {
		DeltaAPI.getClient().getSettingManager().registerSettings(settings);
	}

	public ISetting getSetting(String name) {
		String unlocalizedName = this.getName() + " " + name;
		return DeltaAPI.getClient().getSettingManager().getSettingByInternalName(unlocalizedName);
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
