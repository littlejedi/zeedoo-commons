package com.zeedoo.commons.domain;

import java.util.List;

/**
 * Simple wrapper class that contains a list of sensor data records
 * @author nzhu
 *
 */
public class SensorDataRecords {
	
	private List<SensorDataRecord> sensorDataRecords;
	
	public SensorDataRecords(List<SensorDataRecord> records) {
		sensorDataRecords = records;
	}

	public List<SensorDataRecord> getSensorDataRecords() {
		return sensorDataRecords;
	}

	public void setSensorDataRecords(List<SensorDataRecord> sensorDataRecords) {
		this.sensorDataRecords = sensorDataRecords;
	}
}
