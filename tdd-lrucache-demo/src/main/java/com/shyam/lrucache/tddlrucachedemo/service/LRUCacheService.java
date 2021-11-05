package com.shyam.lrucache.tddlrucachedemo.service;



public interface LRUCacheService 
{
	 public void put(String key, String value) ;
		   
	 public String get(String key) ;

	 public String printCacheValues() ;
}
