package com.zeedoo.core.domain;

import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.junit.Test;

import com.zeedoo.commons.domain.payload.SensorFilePacket;

public class SensorFilePacketTest {

	@Test
	public void deserializesFromJSON() throws Exception {
	    final SensorFilePacket packet = new SensorFilePacket();
	    packet.setCRC32("0");
	    packet.setData("data");
	    packet.setPacketNumber(0);
	    packet.setPacketSize(1924);
	    packet.setSensorId("345678");
	    Assert.assertThat("a Person can be deserialized from JSON",
	               JsonUtils.fromJson(JsonUtils.fixture("fixtures/sensorFilePacket.json"), SensorFilePacket.class),
	               is(packet));
	}

}
