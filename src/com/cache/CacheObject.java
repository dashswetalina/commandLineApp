package com.cache;

import java.util.Set;

public class CacheObject {
	 private Set<String> value;
     private long expiryTime;

     public CacheObject(Set<String> value2, long expiryTime2) {
		this.value=value2;
		this.expiryTime=expiryTime2;
	}

	boolean isExpired() {
         return System.currentTimeMillis() > expiryTime;
     }

	public Object getValue() {
		return value;
	}

	public void setValue(Set<String> value) {
		this.value=value;
	}

	public long getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(long expiryTime) {
		this.expiryTime = expiryTime;
	}
}
