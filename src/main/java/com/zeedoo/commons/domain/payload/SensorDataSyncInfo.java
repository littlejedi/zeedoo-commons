package com.zeedoo.commons.domain.payload;

import com.google.common.base.Objects;

public class SensorDataSyncInfo {
	
	private Integer dataSize;
	
	private Long lastDataSyncTimestamp;

	public Integer getDataSize() {
		return dataSize;
	}

	public void setDataSize(Integer dataSize) {
		this.dataSize = dataSize;
	}

	public Long getLastDataSyncTimestamp() {
		return lastDataSyncTimestamp;
	}

	public void setLastDataSyncTimestamp(Long lastDataSyncTimestamp) {
		this.lastDataSyncTimestamp = lastDataSyncTimestamp;
	}

	@Override
	public int hashCode(){
		return Objects.hashCode(dataSize, lastDataSyncTimestamp);
	}
	
	@Override
	public boolean equals(Object object){
		if (object instanceof SensorDataSyncInfo) {
			SensorDataSyncInfo that = (SensorDataSyncInfo) object;
			return Objects.equal(this.dataSize, that.dataSize)
				&& Objects.equal(this.lastDataSyncTimestamp, that.lastDataSyncTimestamp);
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add("dataSize", dataSize)
			.add("lastDataSyncTimestamp", lastDataSyncTimestamp)
			.toString();
	}
}
