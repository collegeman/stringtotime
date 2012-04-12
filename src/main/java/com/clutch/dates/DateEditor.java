package com.clutch.dates;

import java.beans.PropertyEditorSupport;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

public class DateEditor extends PropertyEditorSupport implements PropertyEditorRegistrar {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Object date = StringToTime.date(text);
		if (!Boolean.FALSE.equals(date))
			setValue((Date) date);
		else
			throw new IllegalArgumentException(String.format("[%s] is not a date.", text));
	}

//	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Date.class, new DateEditor());
		registry.registerCustomEditor(Date.class, new DateEditor());
	}
	
}
