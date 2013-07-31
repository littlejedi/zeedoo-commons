package com.zeedoo.core.domain;

import com.google.common.base.Objects;

/**
 * ApiToken apiKey/apiSecret pair
 * Used for HMAC Authentication
 * @author nzhu
 *
 */
public class ApiToken {
	
	private String apiKey;
	
	private String apiSecret;

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getApiSecret() {
		return apiSecret;
	}

	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(apiKey, apiSecret);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiToken other = (ApiToken) obj;
		return Objects.equal(this.apiKey, other.apiKey) && Objects.equal(this.apiSecret, other.apiSecret);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("apiKey", apiKey).add("apiSecret", apiSecret).toString();
	}
}
