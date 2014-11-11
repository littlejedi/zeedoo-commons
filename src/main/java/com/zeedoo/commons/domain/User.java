package com.zeedoo.commons.domain;

import java.util.Date;
import java.util.UUID;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.Objects;

public class User extends Entity {

	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	//TODO: Use Size annotation
	//@Size()
	private String email;
	
	private String nickname;
	
	private Date registrationDate;
	
	private Date lastLoginDate;
	
	private Date lastLogoutDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getLastLogoutDate() {
		return lastLogoutDate;
	}

	public void setLastLogoutDate(Date lastLogoutDate) {
		this.lastLogoutDate = lastLogoutDate;
	}
		
	@Override
	public int hashCode() {
		return Objects.hashCode(username, password, email, nickname, registrationDate, lastLoginDate, lastLogoutDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equal(this.email, other.email)
				&& Objects.equal(this.username, other.username)
				&& Objects.equal(this.password, other.password)
				&& Objects.equal(this.nickname, other.nickname)
				&& Objects.equal(this.registrationDate, other.registrationDate)
				&& Objects.equal(this.lastLoginDate, other.lastLoginDate)
				&& Objects.equal(this.lastLogoutDate, other.lastLogoutDate);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("email", email).add("username", username)
				.add("nickname", nickname).add("registrationDate", registrationDate)
				.add("lastLoginDate",lastLoginDate).add("lastLogoutDate",lastLogoutDate).toString();
	}
}
