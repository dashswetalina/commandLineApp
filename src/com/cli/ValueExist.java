package com.cli;

import com.cache.CacheImpl;

public class ValueExist {
	public static void isValueExist(String key,String value) {
		CacheImpl impl =CacheImpl.getInstance();
		impl.isValueExist(key, value);
	}

}
