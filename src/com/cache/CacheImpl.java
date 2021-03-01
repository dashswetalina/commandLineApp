package com.cache;

import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CacheImpl implements Cache{
	private static CacheImpl single_instance = null; 
	private static final int CLEAN_UP_PERIOD_IN_SEC = 50000;
	 
    private final ConcurrentHashMap<String, SoftReference<CacheObject>> cache = new ConcurrentHashMap<>();
 
    private CacheImpl() {
        Thread cleanerThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(CLEAN_UP_PERIOD_IN_SEC * 1000);
                    cache.entrySet().removeIf(entry -> Optional.ofNullable(entry.getValue()).map(SoftReference::get).map(CacheObject::isExpired).orElse(false));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        cleanerThread.setDaemon(true);
        cleanerThread.start();
    }

	@Override
	public void add(String key, String value, long periodInMillis) {
		if (key == null) {
            return;
        }
        if (value == null) {
        	 System.out.println("value entered is null");
        } else {
        	Set<String> valueSet;
        	if(cache.containsKey(key)) {
        		SoftReference<CacheObject> obj=cache.get(key);
        		valueSet=(Set<String>) obj.get().getValue();
        		valueSet.add(value);
        	}else {
        		valueSet=new HashSet<String>();
        		valueSet.add(value);
        	}
            long expiryTime = System.currentTimeMillis() + periodInMillis;
            cache.put(key, new SoftReference<>(new CacheObject(valueSet, expiryTime)));
            
        }
		
	}

	@Override
	public void removeAll(String key) {
		if(!cache.containsKey(key)) {
			 System.out.println("ERROR, key does not exist");
		}else {
			cache.remove(key);
			System.out.println("Removed");
		}
		
		
	}

	@Override
	public Object get(String key) {
		
		return Optional.ofNullable(cache.get(key)).map(SoftReference::get).map(CacheObject::getValue).orElse(null);
	}

	@Override
	public void clear() {
		cache.clear();
		
	}

	@Override
	public void getAllKeys() {
		Set<String> keys = cache.keySet();
		if(!keys.isEmpty()) {
			 for(String key: keys){
		            System.out.println(key);
		        }
		}else {
			 System.out.println("(empty set)");
		}
       
		
	} 
	
	@Override
	public void isKeyExist(String key) {
		
        System.out.println(cache.containsKey(key));
	}

	@Override
	public void isValueExist(String key, String value) {
		if(cache.isEmpty()) {
			System.out.println("false");
		}else {
        for(ConcurrentHashMap.Entry<String, SoftReference<CacheObject>> entry : cache.entrySet()){
            if(key.equalsIgnoreCase(entry.getKey())) {
            	Set<String> valueSet=(Set<String>) entry.getValue().get().getValue();
            	System.out.println(valueSet.contains(value));
           
            }
        }
		}
	}

	@Override
	public void getAllValues() {
		if(cache.isEmpty()) {
			System.out.println("(empty set)");
		}else {
		 for(ConcurrentHashMap.Entry<String, SoftReference<CacheObject>> entry : cache.entrySet()){
			 Set<String> valueSet=(Set<String>) entry.getValue().get().getValue();
			 for(String value:valueSet) {
				 System.out.println(value);
			 }
	           
	           
	            
	        }
		}
		
	}

	@Override
	public void getAllItems() {
		if(cache.isEmpty()) {
			System.out.println("(empty set)");
		}else {
			for(ConcurrentHashMap.Entry<String, SoftReference<CacheObject>> entry : cache.entrySet()){
				 Set<String> valueSet=(Set<String>) entry.getValue().get().getValue();
				 for(String value:valueSet) {
					 System.out.println(entry.getKey()+" : "+value);
				 }
		           
		           
		            
		        }
		}
		 
		
	}

	
	@Override
	public void remove(String key, String value) {
		if(cache.containsKey(key)) {
			for(ConcurrentHashMap.Entry<String, SoftReference<CacheObject>> entry : cache.entrySet()){
	            if(key.equalsIgnoreCase(entry.getKey())) {
	            	Set<String> valueSet=(Set<String>) entry.getValue().get().getValue();
	            	
	            	if(valueSet.contains(value)) {
	            		valueSet.remove(value);
	            		if(valueSet.size()==0) {
	            			cache.remove(key);
	            		}
	            		System.out.println("Removed");
	            	}else {
	            		System.out.println("ERROR, value does not exist");
	            	}
	            	
	           
	            }
	        }
		}else {
			System.out.println("ERROR, key does not exist");
		}
		 
		
	} 
	
	public static CacheImpl getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new CacheImpl(); 
  
        return single_instance; 
    }
	

}
