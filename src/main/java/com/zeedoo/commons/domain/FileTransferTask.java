package com.zeedoo.commons.domain;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/**
 * Represents the info and current state of a file transfer
 *
 */
public class FileTransferTask{
	
	// Internal DB id
	private String id;

	// The following 3 fields is a composite primary key
	private String sunMacAddress;
	
	private FileType fileType;
	
	// ID for this file, for SENSOR_DATA_READINGS, this id is the sensor Id
	private String fileId;
	
	private int numberOfPackets;
	
	private int currentPacket;
	
	// For error handling
	private int packetErrorCount = 0;
	
	private String md5;
	
	// The path to the file stored in Mars
	private String filePath;
	
	// Transfer state (defaults to false)
	private boolean completed = false;
	
	public FileTransferTask() {
		// Empty Constructor
	}

	public FileTransferTask(String sunMacAddress, String fileId, String filePath, int numberOfPackets, int currentPacket, String md5, FileType fileType) {
		Preconditions.checkArgument(sunMacAddress != null, "Sun MAC Address should not be null");
		Preconditions.checkArgument(filePath != null, "FilePath should not be null");
		Preconditions.checkArgument(fileId != null, "fileId should not be null");
		Preconditions.checkArgument(md5 != null, "MD5 should not be null");
		this.sunMacAddress = sunMacAddress;
		this.fileId = fileId;
		this.filePath = filePath;
		this.numberOfPackets = numberOfPackets;
		this.currentPacket = currentPacket;
		this.md5 = md5;
		this.fileType = fileType;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getSunMacAddress() {
		return sunMacAddress;
	}

	public void setSunMacAddress(String sunMacAddress) {
		this.sunMacAddress = sunMacAddress;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getNumberOfPackets() {
		return numberOfPackets;
	}

	public void setNumberOfPackets(int numberOfPackets) {
		this.numberOfPackets = numberOfPackets;
	}
	
	public int getCurrentPacket() {
		return currentPacket;
	}

	public void setCurrentPacket(int currentPacket) {
		this.currentPacket = currentPacket;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}
	
	public int getPacketErrorCount() {
		return packetErrorCount;
	}

	public void setPacketErrorCount(int packetErrorCount) {
		this.packetErrorCount = packetErrorCount;
	}

	@Override
	public int hashCode(){
		return Objects.hashCode(id, sunMacAddress, fileType, fileId, numberOfPackets, currentPacket, packetErrorCount, md5, filePath, completed);
	}
	
	@Override
	public boolean equals(Object object){
		if (object instanceof FileTransferTask) {
			FileTransferTask that = (FileTransferTask) object;
			return Objects.equal(this.id, that.id)
				&& Objects.equal(this.sunMacAddress, that.sunMacAddress)
				&& Objects.equal(this.fileType, that.fileType)
				&& Objects.equal(this.fileId, that.fileId)
				&& Objects.equal(this.numberOfPackets, that.numberOfPackets)
				&& Objects.equal(this.currentPacket, that.currentPacket)
				&& Objects.equal(this.packetErrorCount, that.packetErrorCount)
				&& Objects.equal(this.md5, that.md5)
				&& Objects.equal(this.filePath, that.filePath)
				&& Objects.equal(this.completed, that.completed);
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add("sunMacAddress", sunMacAddress)
			.add("fileType", fileType)
			.add("fileId", fileId)
			.add("numberOfPackets", numberOfPackets)
			.add("currentPacket", currentPacket)
			.add("packetErrorCount", packetErrorCount)
			.add("md5", md5)
			.add("filePath", filePath)
			.add("completed", completed)
			.toString();
	}
}