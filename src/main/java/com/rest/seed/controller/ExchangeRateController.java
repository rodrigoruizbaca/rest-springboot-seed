package com.rest.seed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rest.seed.dto.ResponseDTO;
import com.rest.seed.service.ExchangeRateService;

@RestController()
@RequestMapping(value="rate", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExchangeRateController {
	
	@Autowired
	private ExchangeRateService exchangeRateService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("convert/{base}")
	public ResponseDTO convert(@PathVariable("base") String base, @RequestParam("amount") String amount) {
		return exchangeRateService.convert(base, amount);
	}
		
	
}
