package com.example.demo.controller;

import static com.example.demo.constant.Constants.SERVER_UP;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthCheckController {

	
	@GetMapping("/healthcheck")
	public ResponseEntity<String> getHealthCheck() {
		return new ResponseEntity<>(SERVER_UP, HttpStatus.OK);
	}
	
}
