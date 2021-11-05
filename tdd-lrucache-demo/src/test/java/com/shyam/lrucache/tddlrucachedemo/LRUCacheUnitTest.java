package com.shyam.lrucache.tddlrucachedemo;



import com.shyam.lrucache.tddlrucachedemo.datastructure.LRUCache;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class LRUCacheUnitTest {
	
	private LRUCache<String, String> lruCache;
	
	@Test
    public void constructorDoesNotAllowZeroCacheSize() {
        try {
        	 new LRUCache(0);
            fail();
        } catch (IllegalArgumentException expected) {
            //nothing
        }
    }

    @Test
    public void addSomeDataToCache_WhenGetData_ThenIsEqualWithCacheElement() {
    	lruCache = new LRUCache(3);
        lruCache.put("1", "test1");
        lruCache.put("2", "test2");
        lruCache.put("3", "test3");
        assertEquals("test1", lruCache.get("1"));
        assertEquals("test2", lruCache.get("2"));
        assertEquals("test3", lruCache.get("3"));
    }

    @Test
    public void addDataToCacheToTheNumberOfSize_WhenAddOneMoreData_ThenLeastRecentlyDataWillEvict() {
    	lruCache = new LRUCache(3);
        lruCache.put("1", "test1");
        lruCache.put("2", "test2");
        lruCache.put("3", "test3");
        lruCache.put("4", "test4");
        assertNull(lruCache.get("1"));
        
    }
    @Test
    public void cannotPutNullKey() {
    	
        try {
        	lruCache.put(null, "a");
            fail();
        } catch (NullPointerException expected) {
            // nothing
        }
    }

    @Test
    public void cannotPutNullValue() {
    	 
        try {
        	lruCache.put("a", null);
            fail();
        } catch (NullPointerException expected) {
            // nothing
        }
    }
    @Test
    public void throwsWithNullKey() {
        try {
        	lruCache.get(null);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            // nothing
        }
    }
}
