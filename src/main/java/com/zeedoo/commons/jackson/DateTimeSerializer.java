package com.zeedoo.commons.jackson;

import java.io.IOException;

import org.joda.time.DateTime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateTimeSerializer extends JsonSerializer<DateTime> {
    @Override
    public void serialize(DateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
    	 if (provider.isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)) {
             jgen.writeNumber(value.getMillis());
         } else {
             jgen.writeString(value.toString());
         }
    }
}