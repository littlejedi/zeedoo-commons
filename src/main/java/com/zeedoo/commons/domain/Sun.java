package com.zeedoo.commons.domain;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;
import com.zeedoo.commons.jackson.DateTimeDeserializer;
import com.zeedoo.commons.jackson.DateTimeSerializer;

/**
 * Represents a Sun system
 * @author nzhu
 *
 */
public class Sun extends Entity {
	
	// Internal DB id
	private String id;
	
	// External Sun Id
	private String sunId;
	
	// Sun SSID
	private String sunSsid;
	
	private Double latitude;
	
	private Double longitude;
	
	// Human-readable Sun location
	private String location;
	
	// Sun wireless access code
	private String wirelessCode;
	
	// Sun's MAC Address
	private String macAddress;
	
	// Sun's current ip address
	private String currentIpAddress;
	
	// The current port assigned to Sun
	private Integer currentPort;
	
    // Represents Sun's current status
	private DeviceStatus status;
	
	// Last updated timestamp
	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeserializer.class)
	private DateTime updated;
	
	public Sun() {
		//Jackson
	}
	
	public Sun(String sunIpAddress, Integer sunPort, String sunMacAddress, DeviceStatus status) {
		this.macAddress = sunMacAddress;
		this.currentIpAddress = sunIpAddress;
		this.currentPort = sunPort;
		this.status = status;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSunId() {
		return sunId;
	}
	
	public String getSunSsid() {
		return sunSsid;
	}

	public void setSunSsid(String sunSsid) {
		this.sunSsid = sunSsid;
	}
	
	public void setSunId(String sunId) {
		this.sunId = sunId;
	}
	
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWirelessCode() {
		return wirelessCode;
	}

	public void setWirelessCode(String wirelessCode) {
		this.wirelessCode = wirelessCode;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public String getCurrentIpAddress() {
		return currentIpAddress;
	}

	public Integer getCurrentPort() {
		return currentPort;
	}

	public DeviceStatus getStatus() {
		return status;
	}
	
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public void setCurrentIpAddress(String currentIpAddress) {
		this.currentIpAddress = currentIpAddress;
	}

	public void setCurrentPort(Integer currentPort) {
		this.currentPort = currentPort;
	}

	public void setStatus(DeviceStatus status) {
		this.status = status;
	}
	
	public DateTime getUpdated() {
		return updated;
	}

	public void setUpdated(DateTime updated) {
		this.updated = updated;
	}

	@Override
	public int hashCode(){
		return Objects.hashCode(id, sunId, sunSsid, latitude, longitude, location, wirelessCode, macAddress, currentIpAddress, currentPort, status, updated);
	}
	
	@Override
	public boolean equals(Object object){
		if (object instanceof Sun) {
			Sun that = (Sun) object;
			return Objects.equal(this.id, that.id)
				&& Objects.equal(this.sunId, that.sunId)
				&& Objects.equal(this.sunSsid, that.sunSsid)
				&& Objects.equal(this.latitude, that.longitude)
				&& Objects.equal(this.latitude, that.longitude)
				&& Objects.equal(this.location, that.location)
				&& Objects.equal(this.wirelessCode, that.wirelessCode)
				&& Objects.equal(this.macAddress, that.macAddress)
				&& Objects.equal(this.currentIpAddress, that.currentIpAddress)
				&& Objects.equal(this.currentPort, that.currentPort)
				&& Objects.equal(this.status, that.status)
				&& Objects.equal(this.updated, that.updated);
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add("id", id)
			.add("sunId", sunId)
			.add("sunSsid", sunSsid)
			.add("latitude", latitude)
			.add("longitude", longitude)
			.add("location", location)
			.add("wirelessCode", wirelessCode)
			.add("macAddress", macAddress)
			.add("currentIpAddress", currentIpAddress)
			.add("currentPort", currentPort)
			.add("status", status)
			.add("updated", updated)
			.toString();
	}

	
}
