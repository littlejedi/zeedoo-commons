package com.zeedoo.core.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.junit.Test;

import com.zeedoo.commons.domain.DeviceToken;

public class DeviceTokenTest {
	
	@Test
	public void serializesToJSON() throws Exception {
		final DeviceToken token = new DeviceToken();
		token.setTokenId("12345ABCDE");
		token.setUsername("test");
		Assert.assertThat("a Device Token can be serialized to JSON", JsonUtils.asJson(token), is(equalTo(JsonUtils.fixture("fixtures/deviceToken.json"))));
	}
	
	@Test
	public void deserializesFromJSON() throws Exception {
		final DeviceToken token = new DeviceToken();
		token.setTokenId("12345ABCDE");
		token.setUsername("test");
	    Assert.assertThat("a DeviceToken can be deserialized from JSON",
	               JsonUtils.fromJson(JsonUtils.fixture("fixtures/deviceToken.json"), DeviceToken.class),
	               is(token));
	}
}
