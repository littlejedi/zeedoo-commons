package com.zeedoo.commons.domain;

import com.google.common.base.Objects;

public class AppData {

	private String appId;
	
	private String appName;
	
	private String appBuildVersion;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppBuildVersion() {
		return appBuildVersion;
	}

	public void setAppBuildVersion(String appBuildVersion) {
		this.appBuildVersion = appBuildVersion;
	}

	@Override
	public int hashCode(){
		return Objects.hashCode(appId, appName, appBuildVersion);
	}
	
	@Override
	public boolean equals(Object object){
		if (object instanceof AppData) {
			AppData that = (AppData) object;
			return Objects.equal(this.appId, that.appId)
				&& Objects.equal(this.appName, that.appName)
				&& Objects.equal(this.appBuildVersion, that.appBuildVersion);
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add("appId", appId)
			.add("appName", appName)
			.add("appBuildVersion", appBuildVersion)
			.toString();
	}
}
