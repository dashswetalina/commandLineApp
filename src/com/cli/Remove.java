package com.cli;

import com.cache.CacheImpl;

public class Remove {
	public static void remove(String key,String value) {
		CacheImpl impl =CacheImpl.getInstance();
		impl.remove(key, value);
	}
	
	public static void removeAll(String key) {
		CacheImpl impl =CacheImpl.getInstance();
		impl.removeAll(key);
	}

	public static void clear() {
		CacheImpl impl =CacheImpl.getInstance();
		impl.clear();
		System.out.println("Cleared");
	}

}
