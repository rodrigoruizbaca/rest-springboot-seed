package com.rest.seed.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value="", produces = MediaType.ALL_VALUE)
public class PingController {
	
	@GetMapping("ping")
	@ResponseStatus(HttpStatus.OK)
	public String ping() {
		return "pong";
	}
}
