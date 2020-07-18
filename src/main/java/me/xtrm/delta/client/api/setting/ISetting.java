package me.xtrm.delta.client.api.setting;

import java.util.List;

import me.xtrm.delta.client.api.module.IModule;

/**
 * Base interface for any setting
 * @author xTrM_
 */
public interface ISetting {

	/** The display name */
	String getDisplayName();
	/** The parent */
	IModule getParent();
	/** The internal name */
	String getInternalName();
	
	/** Is this a combo setting */
	boolean isCombo();
	/** Get the combo value */
	String getComboValue();
	/** Set the combo value */
	void setComboValue(String value);
	/** Get all combo options*/
	List<String> getComboOptions();
	/** Set the combo options */
	void setComboOptions(List<String> options);
	
	/** Get the current selected combo index */
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
	
	/** Get the next combo index */
	default String getComboNextOption() {
		int optionIndex = getComboOptionIndex();
		if(optionIndex == -42) return getComboOptions().get(0);
		
		optionIndex++;
		if(optionIndex >= getComboOptions().size()) {
			optionIndex = 0;
		}
		
		return getComboOptions().get(optionIndex);
	}
	
	/** Is this a check setting */
	boolean isCheck();
	/** Get the check value */
	boolean getCheckValue();
	/** Set the check value */
	void setCheckValue(boolean value);
	
	/** Is this a slider setting */
	boolean isSlider();
	/** Get the slider value */
	double getSliderValue();
	/** Set the slider value */
	void setSliderValue(double val);
	/** Get the slider's min value */
	double getSliderMin();
	/** Set the slider's min value */
	void setSliderMin(double min);
	/** Get the slider's max value */
	double getSliderMax();
	/** Set the slider's max value */
	void setSliderMax(double max);
	/** Is the slider only allowed integers (false means floats will be used) */
	boolean isSliderOnlyInt();
	
	/** Is this a label setting */
	boolean isLabel();
	/** Get the label value */
	String getLabelString();
	
	/** Is this a spacer setting */
	boolean isSpacer();
	
}
