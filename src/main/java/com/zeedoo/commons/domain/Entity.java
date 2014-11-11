package com.zeedoo.commons.domain;

public abstract class Entity {

	protected String href;
	
	protected String entityType;
	
	// Internal self identifier
	//protected String id;
	
	public Entity() {
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getEntityType() {
		return this.getClass().getSimpleName();
	}

	public void setEntityType(String type) {
		this.entityType = type;
	}
}
