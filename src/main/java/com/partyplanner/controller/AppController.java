package com.partyplanner.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.partyplanner.models.EventDetails;
import com.partyplanner.services.AppService;

@RestController
@RequestMapping("/rest")
@CrossOrigin
public class AppController {

	@Autowired
	private AppService appService;

	@PostMapping(value = "/createEvent")
	public void createEvent(@RequestBody String json) {
		System.out.println(json);
		EventDetails eventData;
		try {
			eventData = new ObjectMapper().readValue(json, EventDetails.class);
			appService.persist(eventData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping(value = "/hello")
	public String hello() {
		return "hello";
	}
}
