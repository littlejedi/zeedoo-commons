package com.zeedoo.commons.domain;

import com.google.common.base.Objects;

public class Link {
	
	private String href;
	
	private String rel;
	
	private String type;

	public Link() {
	}
	
	public Link(String href, String rel, String type) {
		this.href = href;
		this.rel = rel;
		this.type = type;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode(){
		return Objects.hashCode(href, rel, type);
	}
	
	@Override
	public boolean equals(Object object){
		if (object instanceof Link) {
			Link that = (Link) object;
			return Objects.equal(this.href, that.href)
				&& Objects.equal(this.rel, that.rel)
				&& Objects.equal(this.type, that.type);
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add("href", href)
			.add("rel", rel)
			.add("type", type)
			.toString();
	}
}
