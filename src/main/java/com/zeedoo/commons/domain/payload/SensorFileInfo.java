package com.zeedoo.commons.domain.payload;

import com.google.common.base.Objects;

public class SensorFileInfo {
	
	private String md5;
	
	private String sensorId;
	
	private int fileSize;
	
	private int numberOfPackets;
	
	private int packetStartNumber;
	
	public SensorFileInfo() {
		// For JSON mapping
	}
	
	public SensorFileInfo(String sensorId, int numberOfPackets, int packetStartNumber, int fileSize, String md5) {
		this.sensorId = sensorId;
		this.numberOfPackets = numberOfPackets;
		this.packetStartNumber = packetStartNumber;
		this.fileSize = fileSize;
		this.md5 = md5;
	}

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public int fileTransferTaskPool() {
		return numberOfPackets;
	}

	public void setNumberOfPackets(int numberOfPackets) {
		this.numberOfPackets = numberOfPackets;
	}

	public int getPacketStartNumber() {
		return packetStartNumber;
	}

	public void setPacketStartNumber(int packetStartNumber) {
		this.packetStartNumber = packetStartNumber;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}
	
	public int getNumberOfPackets() {
		return numberOfPackets;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(fileSize, md5, numberOfPackets, packetStartNumber, sensorId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SensorFileInfo other = (SensorFileInfo) obj;
		return Objects.equal(this.fileSize, other.fileSize) && Objects.equal(this.md5, other.md5) && Objects.equal(this.numberOfPackets, other.numberOfPackets)
				&& Objects.equal(this.packetStartNumber, other.packetStartNumber) && Objects.equal(this.sensorId, other.sensorId);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("sensorId", sensorId).add("numberOfPackets", numberOfPackets).add("packetStartNumber", packetStartNumber)
				.add("fileSize", fileSize).add("md5", md5).toString();
	}	
}
