package com.zeedoo.core.domain;

import java.io.IOException;
import java.nio.charset.Charset;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class JsonUtils {
	
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	private JsonUtils() {
		//Hidden on purpose
	}
	
	/** 
	 * JSON Utility Methods
	 */	
	public static String fixture(String filename) throws IOException {
		return fixture(filename, Charsets.UTF_8);
	}
	
	public static String fixture(String filename, Charset charset) throws IOException {
        return Resources.toString(Resources.getResource(filename), charset).trim();
    }
	
    public static <T> T fromJson(String json, Class<T> klass) throws IOException {
        return MAPPER.readValue(json, klass);
    }
    
    public static String asJson(Object object) throws IOException {
        return MAPPER.writeValueAsString(object);
    }

}
