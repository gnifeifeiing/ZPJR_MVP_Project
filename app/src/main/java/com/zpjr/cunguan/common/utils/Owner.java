package com.zpjr.cunguan.common.utils;

import java.io.Serializable;

public class Owner implements Serializable {
	@Override
	public String toString() {
		return "Owner{" +
				"realm='" + realm + '\'' +
				", entityId='" + entityId + '\'' +
				'}';
	}

	private String realm;

	private String entityId;

	public String getRealm() {
		return realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

}
