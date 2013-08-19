package com.zeedoo.commons.domain;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;
import com.zeedoo.commons.jackson.DateTimeDeserializer;
import com.zeedoo.commons.jackson.DateTimeSerializer;

/**
 * Represents a Sun's connection status
 * @author nzhu
 *
 */
public class SunStatus {
	
	// Internal DB id
	private String id;
	
	// Represents Sun's MAC address
	private String sunMacAddress;
	
	private String sunIpAddress;
	
	// The port assigned to this Sun device
	private Integer sunPort;
	
	// Sun's online/offline status
	private DeviceStatus sunStatus;
	
	// Last updated timestamp
	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeserializer.class)
	private DateTime lastUpdated;
	
	public SunStatus() {
		// myBatis needs this
	}
	
	public SunStatus(String sunIpAddress, Integer sunPort, String sunMacAddress, DeviceStatus status) {
		this.sunMacAddress = sunMacAddress;
		this.sunIpAddress = sunIpAddress;
		this.sunPort = sunPort;
		this.sunStatus = status;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSunIpAddress() {
		return sunIpAddress;
	}

	public void setSunIpAddress(String sunIpAddress) {
		this.sunIpAddress = sunIpAddress;
	}

	public DeviceStatus getSunStatus() {
		return sunStatus;
	}

	public void setSunStatus(DeviceStatus sunStatus) {
		this.sunStatus = sunStatus;
	}
	
	public String getSunMacAddress() {
		return sunMacAddress;
	}

	public void setSunMacAddress(String sunMacAddress) {
		this.sunMacAddress = sunMacAddress;
	}

	public Integer getSunPort() {
		return sunPort;
	}

	public void setSunPort(Integer sunPort) {
		this.sunPort = sunPort;
	}

	public DateTime getLastUpdated() {
		return lastUpdated;
	}
	
	public void setLastUpdated(DateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	@JsonIgnore
	public DateTime getLastUpdatedLocal() {
		return lastUpdated == null ? null : lastUpdated.toDateTime(DateTimeZone.getDefault());
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("sunMacAddress", sunMacAddress).add("sunIpAddress", sunIpAddress).add("sunPort", sunPort)
				.add("sunStatus", sunStatus).add("lastUpdated", lastUpdated).toString();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, sunMacAddress, sunIpAddress, sunPort, sunStatus, lastUpdated);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SunStatus other = (SunStatus) obj;
		return Objects.equal(this.id, other.id)
				&& Objects.equal(this.sunMacAddress, other.sunMacAddress)
				&& Objects.equal(this.sunIpAddress, other.sunIpAddress)
				&& Objects.equal(this.sunPort, other.sunPort)
				&& Objects.equal(this.sunStatus, other.sunStatus)
				&& Objects.equal(this.lastUpdated, other.lastUpdated);
	}
}
