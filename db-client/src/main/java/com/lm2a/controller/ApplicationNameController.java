package com.lm2a.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lm2a.config.DBConfig;

@RestController
@RequestMapping("/application-name")
public class ApplicationNameController {
	
	private static final Logger log = LoggerFactory.getLogger(ApplicationNameController.class);

	@Autowired
	private DBConfig config;
	
	
	@GetMapping
	public ResponseEntity<String> getAppName(){
		log.info("Respondiendo llamada...");
		return ResponseEntity.ok(config.getApplicationName());
	}
	
	@GetMapping("/activa")
	public ResponseEntity<String> getFunctionality(){
		if(config.isFunctionalityActive()) {
			return ResponseEntity.ok("La funcionalidad esta activa");
		}else {
			return ResponseEntity.ok("La funcionalidad NO esta activa");
		}
	}
}
