package com.zeedoo.commons.domain;

import java.util.List;

public class FindByResult {
	
	// Represents a list of URLs that are found
	private List<String> links;
	
	public FindByResult() {
	}
	
	public FindByResult(List<String> links) {
		this.links = links;
	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
	}
}
