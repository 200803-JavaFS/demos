package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Combines @Controller and @ResponseBody This is part of SpringMVC
public class HelloController {
	
	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		return ResponseEntity.accepted().body("Welcome to Spring Boot!");
	}

}
