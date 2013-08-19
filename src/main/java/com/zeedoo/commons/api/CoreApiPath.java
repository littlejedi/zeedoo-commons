package com.zeedoo.commons.api;

public enum CoreApiPath {

	DEVICE_TOKEN("deviceToken"),
	FIND_BY_SUN_MAC_ADDRESS("findBySunMacAddress"),
	SENSOR_DATA("sensorData"),
	SENSOR_STATUS("sensorStatus"),
	SUN_STATUS("sunStatus"),
	USERS("users");
	
    private String path;
	
	CoreApiPath(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return this.path;
	}
}
