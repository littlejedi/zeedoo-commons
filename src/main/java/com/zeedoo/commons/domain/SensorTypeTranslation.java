package com.zeedoo.commons.domain;

public class SensorTypeTranslation {
	
	private String locale;
	
	private String shortName;
	
	private String longName;

	public SensorTypeTranslation() {
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}
}
