package com.shyam.lrucache.tddlrucachedemo.service;

import org.springframework.stereotype.Service;

import com.shyam.lrucache.tddlrucachedemo.datastructure.LRUCache;



@Service
public class LRUCacheServiceImpl implements LRUCacheService{

	
	private LRUCache<String, String> cache = new LRUCache<>(50);
	
	@Override
	public void put(String key, String value) {
		// TODO Auto-generated method stub
		cache.put(key, value);
	}

	@Override
	public String get(String key) {
		// TODO Auto-generated method stub
		return cache.get(key);
	}

	@Override
	public String printCacheValues() {
		// TODO Auto-generated method stub
		return cache.printCache();
	}

}
