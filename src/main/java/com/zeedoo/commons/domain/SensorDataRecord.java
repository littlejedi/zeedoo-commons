package com.zeedoo.commons.domain;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
		
	//Value of the recording
	private String value;
	
	//Timestamp in MILLISECONDS since epoch
	private Long timestampLong;
		
	public SensorDataRecord() {
		//
	}
	
	public SensorDataRecord(String sensorId, Long timestampLong, String value) {
		this.sensorId = sensorId;
		this.timestampLong = timestampLong;
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
	
	// Convenience fields for Timestamp related data
	// Ignore local timestamp for JSON serialization
	@JsonIgnore
	public DateTime getTimestampLocal() {
		return new DateTime(timestampLong).withZone(DateTimeZone.getDefault());
	}
	
	public Long getTimestampLong() {
		return timestampLong;
	}
	
	public void setTimestampLong(Long timestampLong) {
		this.timestampLong = timestampLong;
	}
	
	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeserializer.class)
	public DateTime getHumanReadableTimestamp() {
		return new DateTime(timestampLong);
	}
	
	public void setHumanReadableTimestamp(DateTime timestamp) {
		// Jackson needs this
	}
		
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode(){
		return Objects.hashCode(id, sensorId, timestampLong, value);
	}
	
	@Override
	public boolean equals(Object object){
		if (object instanceof SensorDataRecord) {
			SensorDataRecord that = (SensorDataRecord) object;
			return Objects.equal(this.id, that.id)
				&& Objects.equal(this.sensorId, that.sensorId)
				&& Objects.equal(this.timestampLong, that.timestampLong)
				&& Objects.equal(this.value, that.value);
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add("id", id)
			.add("sensorId", sensorId)
			.add("timestampLong", timestampLong)
			.add("value", value)
			.toString();
	}
}
