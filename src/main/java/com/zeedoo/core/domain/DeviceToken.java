package com.zeedoo.core.domain;

import com.google.common.base.Objects;

/**
 * Apple Device Token object backed by DB
 * @author nzhu
 *
 */
public class DeviceToken {
	
	private String id;
	
	// this is the actual device token we get from Apple
	private String tokenId;
	
	// associated username
	private String username;
	
	private String nickname;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, tokenId, username, nickname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeviceToken other = (DeviceToken) obj;
		return Objects.equal(this.id, other.id) && Objects.equal(this.tokenId, other.tokenId) && Objects.equal(this.username, other.username) && Objects.equal(this.nickname, other.nickname);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", id).add("tokenId", tokenId).add("username", username).add("nickname", nickname).toString();
	}
}
