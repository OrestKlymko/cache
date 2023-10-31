package com.example.caching.service;

import com.example.caching.model.MyRecord;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;


@Service
public class HighloadService {
	@Cacheable(cacheNames = {"recordsCache"}, key = "#recordId")
	public MyRecord getOrCreateRecordById(int recordId) throws InterruptedException {
		TimeUnit.SECONDS.sleep(3L);
		return new MyRecord(recordId, LocalTime.now());
	}

	@CachePut(cacheNames = {"recordsCache"}, key = "#recordId")
	public MyRecord createOrUpdateRecord(int recordId) {
		return new MyRecord(recordId, LocalTime.now());
	}

	@CacheEvict(cacheNames = {"recordsCache"}, key = "#recordId")
	public void deleteRecord(int recordId){
		//delete object
		return;
	}
}
