package com.lm2a.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.lm2a.service.FakeService;

@RestController
@RequestMapping("/api/v1/dragonball/characters")
public class DragonBallController {
	
	@Autowired
	FakeService fakeService;
	
	private Faker faker = new Faker();
	private List<String> charactersDB = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		for(int i=0; i<20; ++i) {
			charactersDB.add(faker.dragonBall().character());
		}
	}
	
	
	@GetMapping
	public ResponseEntity<List<String>> getCharactersDB(){
		return ResponseEntity.ok(charactersDB);
	}
	
	@GetMapping("/log")
	public ResponseEntity<String> getPringLog() {
		fakeService.printLog();
		return ResponseEntity.ok("Se ha mostrado el log?");
	}

}
