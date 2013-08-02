package com.zeedoo.commons.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;
import com.google.common.base.Objects;

/**
 * Represents a Sensor's connection status
 * @author nzhu
 *
 */
public class SensorStatus {
	
	/**
	 * Internal ID
	 */
	String id;
	
	/**
	 * Sensor Id
	 */
	@NotEmpty
	String sensorId;
	
	/** 
	 * Human-readable IPv4 Address of the Sun that manages this Sensor
	 */
	String sunIpAddress;
	
	Integer sunIpPort;
	
	/**
	 * MAC address of the Sun that manages this Sensor
	 */
	String sunMacAddress;
	
	/**
	 * Device status of this Sensor
	 */
	@NotEmpty
	DeviceStatus sensorStatus;
	
	/**
	 * Last updated
	 */
	@JsonSerialize(using = DateTimeSerializer.class, as=String.class)
	DateTime lastUpdated;
	
	public SensorStatus() {
		// hmm
	}
	
	public SensorStatus(String sensorId, String sunIpAddress, Integer sunIpPort, String sunMacAddress, DeviceStatus sensorStatus) {
		this.sensorId = sensorId;
		this.sunIpAddress = sunIpAddress;
		this.sunIpPort = sunIpPort;
		this.sunMacAddress = sunMacAddress;
		this.sensorStatus = sensorStatus;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public String getSunIpAddress() {
		return sunIpAddress;
	}

	public void setSunIpAddress(String sunIpAddress) {
		this.sunIpAddress = sunIpAddress;
	}

	public Integer getSunIpPort() {
		return sunIpPort;
	}

	public void setSunIpPort(Integer sunIpPort) {
		this.sunIpPort = sunIpPort;
	}

	public String getSunMacAddress() {
		return sunMacAddress;
	}

	public void setSunMacAddress(String sunMacAddress) {
		this.sunMacAddress = sunMacAddress;
	}

	public DeviceStatus getSensorStatus() {
		return sensorStatus;
	}

	public void setSensorStatus(DeviceStatus sensorStatus) {
		this.sensorStatus = sensorStatus;
	}
		
	public DateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(DateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(SensorStatus.class).add("id", id).add("sensorId", sensorId).add("sunIpAddress", sunIpAddress).add("sunIpPort", sunIpPort)
				.add("sunMacAddress", sunMacAddress).add("sensorStatus", sensorStatus).add("lastUpdated", lastUpdated).toString();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, sensorId, sunIpAddress, sunIpPort, sunMacAddress, sensorStatus, lastUpdated);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SensorStatus other = (SensorStatus) obj;
		return  Objects.equal(id, other.id)
				&& Objects.equal(sensorId, other.sensorId) 
				&& Objects.equal(sunIpAddress, other.sunIpAddress)
				&& Objects.equal(sunIpPort, other.sunIpPort)
				&& Objects.equal(sunMacAddress, other.sunMacAddress)
				&& Objects.equal(sensorStatus, other.sensorStatus)
				&& Objects.equal(lastUpdated, other.lastUpdated);
	}
}
