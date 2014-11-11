package com.zeedoo.core.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.zeedoo.commons.domain.User;

public class UserTest {
	
	@Test
	public void serializesToJSON() throws Exception {
		final User user = new User();
		user.setUsername("username");
		user.setPassword("password");
		user.setEmail("email");
		user.setNickname("nickname");
		Assert.assertThat("a User can be serialized to JSON", JsonUtils.asJson(user), is(equalTo(JsonUtils.fixture("fixtures/user.json"))));
	}
	
	@Test
	public void deserializesFromJSON() throws Exception {
	    final User user = new User();
		user.setUsername("username");
		user.setPassword("password");
		user.setEmail("email");
		user.setNickname("nickname");
	    Assert.assertThat("a Person can be deserialized from JSON",
	               JsonUtils.fromJson(JsonUtils.fixture("fixtures/user.json"), User.class),
	               is(user));
	}

}
