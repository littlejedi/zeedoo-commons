package com.zeedoo.commons.api.client;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.urlconnection.HTTPSProperties;
import com.zeedoo.commons.api.filter.HmacClientFilter;
import com.zeedoo.commons.api.filter.PerformanceLoggingFilter;

public class CoreApiClient {
	private WebResource webResource;
	private Client client;
	
	public static ClientConfig configureClient() {
		TrustManager[ ] certs = new TrustManager[ ] {
	            new X509TrustManager() {
					@Override
					public X509Certificate[] getAcceptedIssuers() {
						return null;
					}
					@Override
					public void checkServerTrusted(X509Certificate[] chain, String authType)
							throws CertificateException {
					}
					@Override
					public void checkClientTrusted(X509Certificate[] chain, String authType)
							throws CertificateException {
					}
				}
	    };
	    SSLContext ctx = null;
	    try {
	        ctx = SSLContext.getInstance("TLS");
	        ctx.init(null, certs, new SecureRandom());
	    } catch (java.security.GeneralSecurityException ex) {
	    }
	    HttpsURLConnection.setDefaultSSLSocketFactory(ctx.getSocketFactory());
	    
	    ClientConfig config = new DefaultClientConfig();
	    try {
		    config.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES, new HTTPSProperties(
		        new HostnameVerifier() {
					@Override
					public boolean verify(String hostname, SSLSession session) {
						return true;
					}
		        }, 
		        ctx
		    ));
	    } catch(Exception e) {
	    }
	    return config;
	}
	
	public CoreApiClient(String apiKey, String apiSecret, String baseUrl) {
		client = Client.create(configureClient());
		client.getProperties().put("api_key", apiKey);
		client.getProperties().put("secret_key", apiSecret);
		client.addFilter(new HmacClientFilter(client.getProviders()));
		client.addFilter(new PerformanceLoggingFilter());
		webResource = client.resource(baseUrl);
	}
	
	//TODO: Make it extend Entity, add optional query params param
	public <T extends Object> T get(String url, Class<T> clazz) {
		ClientResponse response = webResource.path(url).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		// We need to gracefully handle NOT_FOUNDs, eg. returning a NULL object instead of throwing a client error.
		if (Status.NOT_FOUND == response.getClientResponseStatus()) {
			return null;
		} else {
			return response.getEntity(clazz);
		}
	}
	
	public <T extends Object> T getWithFullUrl(String fullUrl, Class<T> clazz) {
		ClientResponse response = client.resource(fullUrl).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		// We need to gracefully handle NOT_FOUNDs, eg. returning a NULL object instead of throwing a client error.
		if (Status.NOT_FOUND == response.getClientResponseStatus()) {
			return null;
		} else {
			return response.getEntity(clazz);
		}
	}
	
	public <T extends Object> T getWithQueryParams(String url, Class<T> clazz, MultivaluedMap<String, String> queryParams) {
		ClientResponse response = webResource.path(url).queryParams(queryParams).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		// We need to gracefully handle NOT_FOUNDs, eg. returning a NULL object instead of throwing a client error.
		if (Status.NOT_FOUND == response.getClientResponseStatus()) {
			return null;
		} else {
			return response.getEntity(clazz);
		}
		
	}
	
	public <T extends Object> T put(String url, Class<T> clazz, Object entity) {
		return webResource.path(url).type(MediaType.APPLICATION_JSON).put(clazz, entity);
	}
	
	public <T extends Object> T post(String url, Class<T> clazz, Object entity) {
		if (entity == null) {
			return webResource.path(url).type(MediaType.APPLICATION_JSON).post(clazz);
		}
		return webResource.path(url).type(MediaType.APPLICATION_JSON).post(clazz, entity);
	}
	
	public boolean delete(String url) {
		ClientResponse response = webResource.path(url).type(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
		if (response.getClientResponseStatus() == Status.OK || response.getClientResponseStatus() == Status.NO_CONTENT) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteWithQueryParams(String url, MultivaluedMap<String, String> queryParams) {
		ClientResponse response = webResource.path(url).queryParams(queryParams).type(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
		if (response.getClientResponseStatus() == Status.OK || response.getClientResponseStatus() == Status.NO_CONTENT) {
			return true;
		} else {
			return false;
		}
	}
}
