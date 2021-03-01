package com.cli;

import java.util.Set;

import com.cache.CacheImpl;

public class Members {
	public static void getValue(String key) {
		CacheImpl impl =CacheImpl.getInstance();
		Set<String> valueSet=(Set<String>)impl.get(key);
		if(valueSet==null) {
			System.out.println("ERROR, key does not exist");
		}else {
			for(String val:valueSet) {
				System.out.println(val);
			}
			
		}
		
	}
	
	public static void getAllMembers() {
		CacheImpl impl =CacheImpl.getInstance();
		impl.getAllValues();
		
		
	}

}
