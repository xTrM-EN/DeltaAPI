package me.xtrm.delta.client.api.setting;

import java.util.List;

import me.xtrm.delta.client.api.module.IModule;

public class Setting implements ISetting {
	
	private String name;
	private IModule parent;
	private String internalName;
	
	private SettingType type;
	
	private String comboValue;
	public List<String> comboOptions;
	
	private boolean checkValue;
	
	private double sliderValue;
	private double sliderMin;
	private double sliderMax;
	private boolean sliderOnlyInt;
	
	private String labelValue;

	public Setting(String name, IModule parent, String sval, List<String> options){
		this.name = name;
		this.internalName = parent.getName() + " " + name;
		this.parent = parent;
		this.comboValue = sval;
		this.comboOptions = options;
		this.type = SettingType.COMBO;
	}
	
	public Setting(String name, IModule parent, boolean bval){
		this.name = name;
		this.internalName = parent.getName() + " " + name;
		this.parent = parent;
		this.checkValue = bval;
		this.type = SettingType.CHECK;
	}
	
	public Setting(String name, IModule parent, double dval, double min, double max, boolean onlyint){
		this.name = name;
		this.internalName = parent.getName() + " " + name;
		this.parent = parent;
		this.sliderValue = dval;
		this.sliderMin = min;
		this.sliderMax = max;
		this.sliderOnlyInt = onlyint;
		this.type = SettingType.SLIDER;
	}
	
	public Setting(String name, IModule parent, String label){
		this.name = name;
		this.labelValue = label;
		this.internalName = parent.getName() + " " + name;
		this.parent = parent;
		this.type = SettingType.LABEL;
	}
	
	public Setting(String name, IModule parent){
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

	public enum SettingType {
		CHECK, COMBO, SLIDER, LABEL, SPACER;
	}
}
