package com.news.bean;

import java.io.Serializable;

public class Keywords implements Serializable {

	private static final long serialVersionUID = 7550686843683716881L;

	private Integer keyId;					//关键字编号
	private String keyName;					//关键字名称
	
	public Keywords() {
		super();
	}

	public Keywords(Integer keyId, String keyName) {
		super();
		this.keyId = keyId;
		this.keyName = keyName;
	}

	public Integer getKeyId() {
		return keyId;
	}

	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	@Override
	public String toString() {
		return "Keywords [keyId=" + keyId + ", keyName=" + keyName + "]";
	}
	
	
	
}
