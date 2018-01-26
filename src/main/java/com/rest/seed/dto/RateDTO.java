package com.rest.seed.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RateDTO {
	@JsonProperty("base")
	private String base;
	
	@JsonProperty("date")
	private Date date;
	
	@JsonProperty("rates")
	private Map<String, BigDecimal> rates;

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Map<String, BigDecimal> getRates() {
		return rates;
	}

	public void setRates(Map<String, BigDecimal> rates) {
		this.rates = rates;
	}
	
	
}
