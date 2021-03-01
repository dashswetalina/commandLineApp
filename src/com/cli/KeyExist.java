package com.cli;

import com.cache.CacheImpl;

public class KeyExist {
	public static void isKeyExist(String key) {
		CacheImpl impl =CacheImpl.getInstance();
		impl.isKeyExist(key);
	}
}
