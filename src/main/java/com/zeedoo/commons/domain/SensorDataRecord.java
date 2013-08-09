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
 * Represents a single recording (time and value) from a sensor 
 * @author nzhu
 *
 */
public class SensorDataRecord {
	
	@JsonIgnore
	//Internal DB id
	private String id;
	
	//Sensor Id
	private String sensorId;
	
	//UTC Timestamp when the record was taken (time zone info included)
	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeserializer.class)
	private DateTime timestamp;
	
	//Value of the recording
	private String value;
	
	public SensorDataRecord() {
		//
	}
	
	public SensorDataRecord(String sensorId, DateTime timestamp, String value) {
		this.sensorId = sensorId;
		this.timestamp = timestamp;
		this.value = value;
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
	
	@JsonIgnore
	public DateTime getTimestampLocal() {
		return timestamp.withZone(DateTimeZone.getDefault());
	}

	public DateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(DateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", id).add("sensorId", sensorId).add("timestamp", getTimestampLocal())
				.add("value", value).toString();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, sensorId, timestamp, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SensorDataRecord other = (SensorDataRecord) obj;
		return Objects.equal(id, other.id) && Objects.equal(sensorId, other.sensorId) && Objects.equal(timestamp, other.timestamp)
				&& Objects.equal(value, other.value);
	}
}
