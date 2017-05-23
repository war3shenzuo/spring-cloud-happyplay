package com.sxj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/ribbon/{name}")
	public String consumerHolle(@PathVariable String name) {
		return this.restTemplate.getForObject("http://happyplay-service-test/" + name, String.class);
	}
}
