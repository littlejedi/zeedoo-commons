package com.zeedoo.commons.domain;

import com.zeedoo.commons.mybatis.HasValueEnum;

public enum FileType implements HasValueEnum {
	
	SENSOR_DATA_READINGS(0),
	SENSOR_IMAGE_SNAPSHOT(1),
	SUN_APP_FILE(2);
	
	private int value;
	
	FileType(int value) {
		this.value = value;
	}
	
	@Override
	public int getValue() {
		return this.value;
	}
	
	public static FileType fromValue(int value) {
		switch (value) {
		case 0:
			return FileType.SENSOR_DATA_READINGS;
		case 1:
			return FileType.SENSOR_IMAGE_SNAPSHOT;
		case 2:
			return FileType.SUN_APP_FILE;
		default:
			throw new IllegalArgumentException(
					"Unknown FileType value: " + value);
		}
	}

}
