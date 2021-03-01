package com.cli;

import java.util.Set;

import com.cache.CacheImpl;

public class Add {
	
	public static void addCache(String key,String value) {
		CacheImpl impl =CacheImpl.getInstance();
		Set<String> valueSet=(Set<String>)impl.get(key);
		if (valueSet!=null && valueSet.contains(value)){			
			System.out.println("ERROR, value already exists");
		}else {
			impl.add(key, value, 50000);
			System.out.println("Added");
		}
		
		
	}

}
