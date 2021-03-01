package com.cache;

public interface Cache {
	
	    
	    void add(String key, String value, long periodInMillis);
	 
	    Object get(String key);
	 
	    void clear();
	    
	    void getAllKeys();
	    
	    void isKeyExist(String key);
	    
	    void isValueExist(String key,String value);
	    
	    void getAllValues();
	    
	    void getAllItems();
	    
	    void removeAll(String key);
	    
	    void remove(String key,String value);
	
}
