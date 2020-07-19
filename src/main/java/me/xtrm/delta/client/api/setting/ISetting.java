package me.xtrm.delta.client.api.setting;

import java.util.List;

import me.xtrm.delta.client.api.module.IModule;

/**
 * Base interface for any setting
 * @author xTrM_
 */
public interface ISetting {

	/** 
	 * @return the display name 
	 */
	String getDisplayName();
	/** 
	 * @return the parent
	 */
	IModule getParent();
	/** 
	 * @return the internal name 
	 */
	String getInternalName();
	
	/** 
	 * @return if this a combo setting 
	 */
	boolean isCombo();
	/** 
	 * @return the combo value 
	 */
	String getComboValue();
	/** 
	 * @param value
	 * 		the combo value 
	 */
	void setComboValue(String value);
	/**
	 * @return the combo options
	 */
	List<String> getComboOptions();
	/** 
	 * @param options
	 * 		the combo options 
	 */
	void setComboOptions(List<String> options);
	
	/** 
	 * @return the current selected combo index 
	 */
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
	
	/** 
	 * @return the next combo index 
	 */
	default String getComboNextOption() {
		int optionIndex = getComboOptionIndex();
		if(optionIndex == -42) return getComboOptions().get(0);
		
		optionIndex++;
		if(optionIndex >= getComboOptions().size()) {
			optionIndex = 0;
		}
		
		return getComboOptions().get(optionIndex);
	}
	
	/** 
 	 * @return if this a check setting 
 	 */
	boolean isCheck();
	/**
	 * @return the check value 
	 */
	boolean getCheckValue();
	/**
	 * @param value
	 * 		the check value 
	 */
	void setCheckValue(boolean value);
	
	/**
	 * @return if this a slider setting 
	 */
	boolean isSlider();
	/** 
 	 * @return the slider value 
 	 */
	double getSliderValue();
	/**
	 * @param value
	 *		the slider value 
	 */
	void setSliderValue(double value);
	/**
	 * @return the slider's min value 
	 */
	double getSliderMin();
	/**
	 * @param minValue
	 * 		the slider's min value 
	 */
	void setSliderMin(double minValue);
	/** 
	 * @return the slider's max value 
	 */
	double getSliderMax();
	/** 
	 * @param maxValue
	 * 		the slider's max value 
	 */
	void setSliderMax(double maxValue);
	/** 
	 * @return if the slider only allowed integers (false means <code>double</code> will be used) 
	 */
	boolean isSliderOnlyInt();
	
	/**
	 * @return if this a label setting 
	 */
	boolean isLabel();
	/**
	 * @return the label value 
	 */
	String getLabelString();
	
	/** 
	 * @return if this a spacer setting 
	 */
	boolean isSpacer();
	
}
