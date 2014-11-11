package com.zeedoo.commons.domain;

import java.util.List;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

public class FindByResult {
	
	// Represents the total count
	private int totalCount;
	
	// Represents a list of URLs that are found
	private List<String> links;
	
	public FindByResult() {
	}
	
	public FindByResult(List<String> links) {
		if (links != null) {
			this.links = links;
		} else {
			this.links = Lists.newArrayList();
		}
		this.totalCount = links != null ? links.size() : 0;
	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public int hashCode(){
		return Objects.hashCode(totalCount, links);
	}
	
	@Override
	public boolean equals(Object object){
		if (object instanceof FindByResult) {
			FindByResult that = (FindByResult) object;
			return Objects.equal(this.totalCount, that.totalCount)
				&& Objects.equal(this.links, that.links);
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add("totalCount", totalCount)
			.add("links", links)
			.toString();
	}
}
