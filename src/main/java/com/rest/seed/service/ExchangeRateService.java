package com.rest.seed.service;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.rest.seed.dto.RateDTO;
import com.rest.seed.dto.ResponseDTO;

@Service
public class ExchangeRateService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${rest.endpoint}")
	private String endpoint;
	
	
	public ResponseDTO convert(String base, String amount) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		ResponseDTO responseDto = new ResponseDTO();
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(endpoint)
		        .queryParam("base", base)
		        .queryParam("symbols", "MXN");
		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<RateDTO> response = restTemplate.exchange(
		        builder.build().encode().toUri(), 
		        HttpMethod.GET, 
		        entity, 
		        RateDTO.class);
		RateDTO rateObj = response.getBody();
		
		Map<String, BigDecimal> rates = rateObj.getRates();
		BigDecimal rate = rates.get("MXN");
		
		
		responseDto.setRate(rate.multiply(new BigDecimal(amount)));
		return responseDto;
	}
}
