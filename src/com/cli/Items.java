package com.cli;

import com.cache.CacheImpl;

public class Items {
	public static void getAllItems() {
		CacheImpl impl =CacheImpl.getInstance();
		impl.getAllItems();
	}

}
