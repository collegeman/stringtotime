package com.clutch.dates;

public class StringToTimeException extends RuntimeException {
	
	private static final long serialVersionUID = -3777846121104246071L;

	public StringToTimeException(Object dateTimeString) {
		super(String.format("Failed to parse [%s] into a java.util.Date", dateTimeString));
	}
	
	public StringToTimeException(Object dateTimeString, Throwable cause) {
		super(String.format("Failed to parse [%s] into a java.util.Date", dateTimeString), cause);
	}

}
