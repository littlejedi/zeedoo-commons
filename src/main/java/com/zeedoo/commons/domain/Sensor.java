package com.zeedoo.commons.domain;

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zeedoo.commons.jackson.DateTimeDeserializer;
import com.zeedoo.commons.jackson.DateTimeSerializer;
import com.google.common.base.Objects;

/**
 * Represents a Sensor
 * @author nzhu
 *
 */
public class Sensor extends Entity {
	
	/**
	 * DB Internal Id
	 */
	@JsonIgnore
	private String id;
	
	/**
	 * External Sensor Id
	 */
	private String sensorId;
	
	/**
	 * Sensor Mac ID
	 */
	private String sensorMacId;
	
	/**
	 * Sensor's scale
	 */
	private Integer sensorScale;
	
	/**
	 * Sensor's access hash
	 */
	private String sensorAccessHash;
	
	/**
	 * Sensor Type Id
	 */
	private String sensorTypeId;
	
	/**
	 * The username associated with the sensor
	 */
	private String sensorUsername;
	
	/**
	 * Sensor Status
	 */
	@NotNull
	private DeviceStatus sensorStatus;
	
	/** 
	 * Internal Sun ipAddress
	 */
	private String sunIpAddress;
	
	/**
	 * The service port of the Sun device
	 */
	private Integer sunIpPort;
	
	/**
	 * MAC address of the Sun that manages this Sensor
	 */
	private String sunMacAddress;
	
	/**
	 * Last updated
	 */
	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeserializer.class)
	private DateTime lastStatusUpdated;
	
	public Sensor() {
		// Jackson needs this
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

	public String getSensorMacId() {
		return sensorMacId;
	}

	public void setSensorMacId(String sensorMacId) {
		this.sensorMacId = sensorMacId;
	}

	public Integer getSensorScale() {
		return sensorScale;
	}

	public void setScale(Integer sensorScale) {
		this.sensorScale = sensorScale;
	}

	public String getSensorAccessHash() {
		return sensorAccessHash;
	}

	public void setSensorAccessHash(String sensorAccessHash) {
		this.sensorAccessHash = sensorAccessHash;
	}

	public String getSensorTypeId() {
		return sensorTypeId;
	}

	public void setSensorTypeId(String sensorTypeId) {
		this.sensorTypeId = sensorTypeId;
	}

	public String getSensorUsername() {
		return sensorUsername;
	}

	public void setSensorUsername(String sensorUsername) {
		this.sensorUsername = sensorUsername;
	}

	public DeviceStatus getSensorStatus() {
		return sensorStatus;
	}

	public void setSensorStatus(DeviceStatus sensorStatus) {
		this.sensorStatus = sensorStatus;
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

	public DateTime getLastStatusUpdated() {
		return lastStatusUpdated;
	}

	public void setLastStatusUpdated(DateTime lastStatusUpdated) {
		this.lastStatusUpdated = lastStatusUpdated;
	}

	@Override
	public int hashCode(){
		return Objects.hashCode(id, sensorId, sensorMacId, sensorScale, sensorAccessHash, sensorTypeId, sensorUsername, sensorStatus, sunIpAddress, sunIpPort, sunMacAddress, lastStatusUpdated);
	}
	
	@Override
	public boolean equals(Object object){
		if (object instanceof Sensor) {
			Sensor that = (Sensor) object;
			return Objects.equal(this.id, that.id)
				&& Objects.equal(this.sensorId, that.sensorId)
				&& Objects.equal(this.sensorMacId, that.sensorMacId)
				&& Objects.equal(this.sensorScale, that.sensorScale)
				&& Objects.equal(this.sensorAccessHash, that.sensorAccessHash)
				&& Objects.equal(this.sensorTypeId, that.sensorTypeId)
				&& Objects.equal(this.sensorUsername, that.sensorUsername)
				&& Objects.equal(this.sensorStatus, that.sensorStatus)
				&& Objects.equal(this.sunIpAddress, that.sunIpAddress)
				&& Objects.equal(this.sunIpPort, that.sunIpPort)
				&& Objects.equal(this.sunMacAddress, that.sunMacAddress)
				&& Objects.equal(this.lastStatusUpdated, that.lastStatusUpdated);
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add("id", id)
			.add("sensorId", sensorId)
			.add("sensorMacId", sensorMacId)
			.add("scale", sensorScale)
			.add("sensorAccessHash", sensorAccessHash)
			.add("sensorTypeId", sensorTypeId)
			.add("sensorUsername", sensorUsername)
			.add("sensorStatus", sensorStatus)
			.add("sunIpAddress", sunIpAddress)
			.add("sunIpPort", sunIpPort)
			.add("sunMacAddress", sunMacAddress)
			.add("lastStatusUpdated", lastStatusUpdated)
			.toString();
	}
}
