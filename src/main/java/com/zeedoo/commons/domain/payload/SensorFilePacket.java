package com.zeedoo.commons.domain.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class SensorFilePacket {
	
	private String sensorId;
	
	private int packetNumber;
	
	private int packetSize;
	
	/**
	 * Base64 encoded string that represents original binary data
	 */
	private String data;
	
	@JsonProperty("CRC32")
	private String CRC32;

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public int getPacketNumber() {
		return packetNumber;
	}

	public void setPacketNumber(int packetNumber) {
		this.packetNumber = packetNumber;
	}

	public int getPacketSize() {
		return packetSize;
	}

	public void setPacketSize(int packetSize) {
		this.packetSize = packetSize;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCRC32() {
		return CRC32;
	}

	public void setCRC32(String crc32) {
		CRC32 = crc32;
	}

	@Override
	public int hashCode(){
		return Objects.hashCode(sensorId, packetNumber, packetSize, data, CRC32);
	}
	
	@Override
	public boolean equals(Object object){
		if (object instanceof SensorFilePacket) {
			SensorFilePacket that = (SensorFilePacket) object;
			return Objects.equal(this.sensorId, that.sensorId)
				&& Objects.equal(this.packetNumber, that.packetNumber)
				&& Objects.equal(this.packetSize, that.packetSize)
				&& Objects.equal(this.data, that.data)
				&& Objects.equal(this.CRC32, that.CRC32);
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add("sensorId", sensorId)
			.add("packetNumber", packetNumber)
			.add("packetSize", packetSize)
			.add("CRC32", CRC32)
			.toString();
	}
}
