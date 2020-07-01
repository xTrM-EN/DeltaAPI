package me.xtrm.delta.client.api.setting;

import java.util.List;

import me.xtrm.delta.client.api.module.IModule;

public interface ISetting {

	String getDisplayName();
	IModule getParent();
	String getInternalName();
	
	boolean isCombo();
	String getComboValue();
	void setComboValue(String value);
	List<String> getComboOptions();
	void setComboOptions(List<String> options);
	
	default int getComboOptionIndex() {
		int optionIndex = 0;
		for(String s : getComboOptions()) {
			if(s.equalsIgnoreCase(getComboValue())) {
				return optionIndex;
			}
			optionIndex++;
		}
		return -42;
	}
	
	default String getComboNextOption() {
		int optionIndex = getComboOptionIndex();
		if(optionIndex == -42) 
			return getComboOptions().get(0);
		
		optionIndex++;
		if(optionIndex >= getComboOptions().size()) {
			optionIndex = 0;
		}
		
		return getComboOptions().get(optionIndex);
	}
	
	boolean isCheck();
	boolean getCheckValue();
	void setCheckValue(boolean value);
	
	boolean isSlider();
	double getSliderValue();
	void setSliderValue(double val);
	double getSliderMin();
	void setSliderMin(double min);
	double getSliderMax();
	void setSliderMax(double max);
	boolean isSliderOnlyInt();
	
	boolean isLabel();
	String getLabelString();
	
	boolean isSpacer();
	
}
