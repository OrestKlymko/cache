package com.example.caching.controller;

import com.example.caching.model.MyRecord;
import com.example.caching.service.HighloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HighloadController {

	@Autowired
	private HighloadService highloadService;


	@GetMapping("/{id}")
	public MyRecord getOrCreate(@PathVariable("id") int id){
		try {
			return highloadService.getOrCreateRecordById(id);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@PutMapping("/{id}")
	public MyRecord createOrUpdate(@PathVariable("id") int id){
		return highloadService.createOrUpdateRecord(id);
	}
}
