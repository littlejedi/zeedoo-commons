package com.zeedoo.commons.api.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

public class PerformanceLoggingFilter extends ClientFilter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceLoggingFilter.class);

	@Override
	public ClientResponse handle(ClientRequest cr) throws ClientHandlerException {
		long before = System.currentTimeMillis();	
		// Call the next client handler in the filter chain
		ClientResponse resp = getNext().handle(cr);
		long after = System.currentTimeMillis();
		long timeElapsed = after - before;

		LOGGER.info("{} {} took {} ms", cr.getMethod(), cr.getURI(), timeElapsed);

		return resp;
	}

}
