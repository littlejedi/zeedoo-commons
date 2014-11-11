package com.zeedoo.commons.api.filter;

import com.google.common.collect.Lists;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.zeedoo.commons.hmac.HmacUtils;
import com.zeedoo.commons.utils.DateUtils;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Providers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * <p>Client filter to provide the following to requests:</p>
 * <ul>
 * <li>Addition of Authorization information to client requests</li>
 * </ul>
 *
 * @since 0.0.1
 */
public class HmacClientFilter extends ClientFilter {

	public static final String API_KEY = "api_key";
	  public static final String SECRET_KEY = "secret_key";

	  private static final Logger LOGGER = LoggerFactory.getLogger(HmacClientFilter.class);

	  private final Providers providers;

	  public HmacClientFilter(Providers providers) {
	    this.providers = providers;
	  }

	  public ClientResponse handle(ClientRequest cr) {
	    ClientRequest mcr = modifyRequest(cr);

	    // Call the next client handler in the filter chain
	    ClientResponse resp = getNext().handle(mcr);

	    // Modify the response
	    return modifyResponse(resp);
	  }

	  /**
	   * Handles the process of modifying the outbound request with suitable HMAC headers
	   *
	   * @param clientRequest The original client request
	   * @return The modified client request
	   */
	  private ClientRequest modifyRequest(ClientRequest clientRequest) {

	    // Check for modifications to the API key through properties
	    Map<String, Object> properties = clientRequest.getProperties();
	    if (properties == null) {
	      throw new IllegalStateException("Client request properties are null");
	    }
	    if (!properties.containsKey(API_KEY) ) {
	      throw new IllegalStateException("Client request '"+ API_KEY +"' is null");
	    }
	    if (!properties.containsKey(SECRET_KEY) ) {
	      throw new IllegalStateException("Client request '"+ SECRET_KEY +"' is null");
	    }
	    String publicKey = properties.get(API_KEY).toString();
	    String sharedSecret = properties.get(SECRET_KEY).toString();

	    // Provide a short TTL
	    String httpNow = DateUtils.formatHttpDateHeader(DateUtils.nowUtc().plusSeconds(5));
	    clientRequest.getHeaders().put(HmacUtils.X_HMAC_DATE, Lists.<Object>newArrayList(httpNow));

	    String canonicalRepresentation = HmacUtils.createCanonicalRepresentation(clientRequest,providers);
	    LOGGER.debug("Client side canonical representation: '{}'", canonicalRepresentation);

	    // Build the authorization header
	    String signature = new String(HmacUtils.computeSignature("HmacSHA1", canonicalRepresentation, sharedSecret));
	    String authorization = "HMAC " + publicKey + " " + signature;
	    clientRequest.getHeaders().put(HttpHeaders.AUTHORIZATION, Lists.<Object>newArrayList(authorization));

	    String curlCommand = HmacUtils.createCurlCommand(clientRequest,providers, canonicalRepresentation, sharedSecret, publicKey);
	    LOGGER.debug("Client side curl command: '{}'", curlCommand);

	    return clientRequest;
	  }

	  private ClientResponse modifyResponse(ClientResponse resp) {
	    // Placeholder to complete the implementation
	    return resp;
	  }
}