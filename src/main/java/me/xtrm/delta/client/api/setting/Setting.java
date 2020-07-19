package me.xtrm.delta.client.api.setting;

import java.util.Arrays;
import java.util.List;

import me.xtrm.delta.client.api.module.IModule;

/**
 * Simple implementation for {@link ISetting}
 * @author xTrM_
 */
public class Setting implements ISetting {
	
	/** The name */
	private String name;
	/** The parent */
	private IModule parent;
	/** The internal name */
	private String internalName;
	
	/** The setting type */
	private SettingType type;
	
	/** The combo value */
	private String comboValue;
	/** The combo options*/
	public List<String> comboOptions;
	
	/** The check value */
	private boolean checkValue;
	
	/** The slider value */
	private double sliderValue;
	/** The slider's min value */
	private double sliderMin;
	/** The slider's max value */
	private double sliderMax;
	/** Is the slider only allowed integers (false means <code>double</code> will be used) */
	private boolean sliderOnlyInt;
	
	/** The label value */
	private String labelValue;

	/**
	 * Constructor for a Combo setting
	 * @param name
	 * 		the setting's displayed name
	 * @param parent
	 * 		the setting's parent {@link IModule}
	 * @param defaultValue
	 * 		the setting's default {@link String} value
	 * @param options
	 * 		the setting's {@link String} options
	 */
	public Setting(String name, IModule parent, String defaultValue, String... options) {
		this(name, parent, defaultValue, Arrays.asList(options));
	}
	
	/**
	 * Constructor for a Combo setting
	 * @param name
	 * 		the setting's displayed name
	 * @param parent
	 * 		the setting's parent {@link IModule}
	 * @param defaultValue
	 * 		the setting's default {@link String} value
	 * @param options
	 * 		the setting's {@link String} options
	 */
	public Setting(String name, IModule parent, String defaultValue, List<String> options) {
		this.name = name;
		this.internalName = parent.getName() + " " + name;
		this.parent = parent;
		this.comboValue = defaultValue;
		this.comboOptions = options;
		this.type = SettingType.COMBO;
	}
	
	/**
	 * Constructor for a Check setting
	 * @param name
	 * 		the setting's displayed name
	 * @param parent
	 * 		the setting's parent {@link IModule}
	 * @param defaultValue
	 * 		the setting's default {@link Boolean} value
	 */
	public Setting(String name, IModule parent, boolean defaultValue) {
		this.name = name;
		this.internalName = parent.getName() + " " + name;
		this.parent = parent;
		this.checkValue = defaultValue;
		this.type = SettingType.CHECK;
	}
	
	/**
	 * Constructor for a Slider setting
	 * @param name
	 * 		the setting's displayed name
	 * @param parent
	 * 		the setting's parent {@link IModule}
	 * @param defaultValue
	 * 		the setting's default {@link Double} value
	 * @param min
	 * 		the setting's minimum {@link Double} value
	 * @param max
	 * 		the setting's maximum {@link Double} value
	 * @param onlyint
	 * 		if the slider only allowed integers (false means <code>double</code> will be used)
	 */
	public Setting(String name, IModule parent, double defaultValue, double min, double max, boolean onlyint) {
		this.name = name;
		this.internalName = parent.getName() + " " + name;
		this.parent = parent;
		this.sliderValue = defaultValue;
		this.sliderMin = min;
		this.sliderMax = max;
		this.sliderOnlyInt = onlyint;
		this.type = SettingType.SLIDER;
	}
	
	/**
	 * Constructor for a Label setting
	 * @param name
	 * 		the setting's displayed name
	 * @param parent
	 * 		the setting's parent {@link IModule}
	 * @param label
	 * 		the setting's {@link String} label
	 */
	public Setting(String name, IModule parent, String label) {
		this.name = name;
		this.labelValue = label;
		this.internalName = parent.getName() + " " + name;
		this.parent = parent;
		this.type = SettingType.LABEL;
	}
	
	/**
	 * Constructor for a Spacer setting
	 * @param name
	 * 		the setting's displayed name
	 * @param parent
	 * 		the setting's parent {@link IModule}
	 */
	public Setting(String name, IModule parent) {
		this.name = name;
		this.internalName = parent.getName() + " " + name;
		this.parent = parent;
		this.type = SettingType.SPACER;
	}
	
	@Override
	public String getDisplayName() {
		return name;
	}

	@Override
	public IModule getParent() {
		return parent;
	}

	@Override
	public String getInternalName() {
		return internalName;
	}

	@Override
	public boolean isCombo() {
		return type == SettingType.COMBO;
	}

	@Override
	public String getComboValue() {
		return comboValue;
	}

	@Override
	public void setComboValue(String value) {
		this.comboValue = value;
	}
	
	@Override
	public List<String> getComboOptions() {
		return comboOptions;
	}
	
	@Override
	public void setComboOptions(List<String> options) {
		this.comboOptions = options;
	}

	@Override
	public boolean isCheck() {
		return type == SettingType.CHECK;
	}

	@Override
	public boolean getCheckValue() {
		return checkValue;
	}

	@Override
	public void setCheckValue(boolean value) {
		this.checkValue = value;
	}

	@Override
	public boolean isSlider() {
		return type == SettingType.SLIDER;
	}

	@Override
	public double getSliderValue() {
		return sliderValue;
	}

	@Override
	public void setSliderValue(double val) {
		this.sliderValue = val;
	}

	@Override
	public double getSliderMin() {
		return sliderMin;
	}

	@Override
	public void setSliderMin(double min) {
		this.sliderMin = min;
	}

	@Override
	public double getSliderMax() {
		return sliderMax;
	}

	@Override
	public void setSliderMax(double max) {
		this.sliderMax = max;
	}

	@Override
	public boolean isSliderOnlyInt() {
		return sliderOnlyInt;
	}

	@Override
	public boolean isLabel() {
		return type == SettingType.LABEL;
	}

	@Override
	public String getLabelString() {
		return labelValue;
	}

	@Override
	public boolean isSpacer() {
		return type == SettingType.SPACER;
	}

	/**
	 * An enum to differenciate between setting types
	 * @author xTrM_
	 */
	public enum SettingType {
		CHECK, COMBO, SLIDER, LABEL, SPACER;
	}
}
