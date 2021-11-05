package com.shyam.lrucache.tddlrucachedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shyam.lrucache.tddlrucachedemo.model.Requestbody;
import com.shyam.lrucache.tddlrucachedemo.service.LRUCacheService;


@RestController
@RequestMapping("/cache")
public class LRUCacheController {

	@Autowired
	private LRUCacheService cacheService;
	
	@PostMapping("/addtocache")
	  public ResponseEntity<?> addToLRUCache(@RequestBody Requestbody request) {
	    cacheService.put(request.getKey(), request.getValue());
	    return ResponseEntity.noContent().build();
	  }

	  @GetMapping("/getcache/keys/{key}")
	  public ResponseEntity<?> get(@PathVariable String key) {
	    return ResponseEntity.ok(cacheService.get(key));
	  }

	  @GetMapping("/getallcache")
	  public ResponseEntity<?> get() {
	    return ResponseEntity.ok(cacheService.printCacheValues());
}
}