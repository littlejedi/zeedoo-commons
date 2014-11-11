package com.zeedoo.commons.api;

public enum CoreApiPath {

	DEVICE_TOKEN("deviceToken"),
	FIND_BY("findBy"),
	FIND_BY_SUN_MAC_ADDRESS_AND_USERNAME("findBySunMacAddressAndUsername"),
	/**
	 * FileTransferTask
	 */
	FILE_TRANSFER_TASK("fileTransferTask"),
	/**
	 * Sensor
	 */
	SENSOR("sensor"),
	SENSOR_DATA("sensorData"),
	/**
	 * Sun
	 */
	SUN("sun"),
	SUN_ID("id"),
	SUN_MAC_ADDRESS("macAddress"),
	SUN_SOCKETADDRESS("socketAddress"),
	/**
	 * Users
	 */
	USERS("users"),
	/**
	 * FindBy query params
	 */
	SHOW_FULL_ENTITY("fullEntity"),
	PAGE_SIZE("pageSize");
	
    private String path;
	
	CoreApiPath(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return this.path;
	}
}
