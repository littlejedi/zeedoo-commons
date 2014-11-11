package com.zeedoo.commons.domain;

import java.util.List;

public class SensorType {
	
	private Integer id;
	
	private String name;
	
	private String unit;
	
	private List<SensorTypeTranslation> translations;

	public SensorType() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public List<SensorTypeTranslation> getTranslations() {
		return translations;
	}

	public void setTranslations(List<SensorTypeTranslation> translations) {
		this.translations = translations;
	}
}
