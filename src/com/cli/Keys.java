package com.cli;

import com.cache.CacheImpl;

public class Keys {
	
	public static void getKeys() {
		CacheImpl impl =CacheImpl.getInstance();
		impl.getAllKeys();
	}

}
