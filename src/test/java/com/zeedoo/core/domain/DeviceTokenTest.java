package com.zeedoo.core.domain;

import static com.yammer.dropwizard.testing.JsonHelpers.asJson;
import static com.yammer.dropwizard.testing.JsonHelpers.fromJson;
import static com.yammer.dropwizard.testing.JsonHelpers.jsonFixture;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class DeviceTokenTest {
	
	@Test
	public void serializesToJSON() throws Exception {
		final DeviceToken token = new DeviceToken();
		token.setTokenId("12345ABCDE");
		token.setUsername("test");
		Assert.assertThat("a Device Token can be serialized to JSON", asJson(token), is(equalTo(jsonFixture("fixtures/deviceToken.json"))));
	}
	
	@Test
	public void deserializesFromJSON() throws Exception {
		final DeviceToken token = new DeviceToken();
		token.setTokenId("12345ABCDE");
		token.setUsername("test");
	    Assert.assertThat("a DeviceToken can be deserialized from JSON",
	               fromJson(jsonFixture("fixtures/deviceToken.json"), DeviceToken.class),
	               is(token));
	}
}
