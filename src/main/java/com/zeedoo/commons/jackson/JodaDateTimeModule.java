package com.zeedoo.commons.jackson;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class JodaDateTimeModule extends SimpleModule {
	
    public JodaDateTimeModule() {
        addDeserializer(DateTime.class, new DateTimeDeserializer());
        addSerializer(DateTime.class, new DateTimeSerializer());
    }
}