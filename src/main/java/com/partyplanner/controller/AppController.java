package com.partyplanner.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.partyplanner.models.BudgetCategory;
import com.partyplanner.models.EventDetails;
import com.partyplanner.models.Food;
import com.partyplanner.models.Guest;
import com.partyplanner.models.Location;
import com.partyplanner.services.AppService;
import com.partyplanner.services.EmailServiceProvider;

@RestController
@RequestMapping("/rest")
@CrossOrigin
public class AppController {

	@Autowired
	private AppService appService;

	@Autowired
	private EmailServiceProvider emailService;

	@PostMapping(value = "/createEvent")
	public String createEvent(@RequestBody String json) {
		System.out.println(json);
		EventDetails eventData;
		try {
			eventData = new ObjectMapper().readValue(json, EventDetails.class);
			appService.persist(eventData);
			return "Saved Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error Ocurred while Saving";
		}
	}

	@GetMapping(value = "/fetchBudgetCategory")
	public List<BudgetCategory> fetchBudgetCategory() {
		System.out.println("done");
		return appService.fetchCategoryData();
	}

	@GetMapping(value = "/fetchLocationList")
	public List<Location> fetchLocationList() {
		System.out.println("LocationData");
		return appService.fetchLocationData();
	}

	@GetMapping(value = "/fetchFoodList")
	public List<Food> fetchFoodList() {
		System.out.println("FoodData");
		return appService.fetchFoodData();
	}

	@GetMapping(value = "/fetchGuestList")
	public List<Guest> fetchGuestList() {
		System.out.println("GuestData");
		return appService.fetchGuestData();
	}

	@PostMapping(value = "/updateBudgetCategoryData")
	public void updateBudgetCategoryData(@RequestBody String jsonData) {
		System.out.println("updating");
		BudgetCategory ctgy;
		try {
			ctgy = new ObjectMapper().readValue(jsonData, BudgetCategory.class);
			appService.updateCategoryData(ctgy);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping(value = "/events")
	public List<EventDetails> getAllevents() {
		List<EventDetails> evnt = appService.get();
		return evnt;
	}

	@GetMapping(value = "/event/{id}")
	public Optional<EventDetails> getEventById(@PathVariable int id) {
		Optional<EventDetails> evnt = appService.getEventById(id);
		return evnt;
	}

	@RequestMapping(value = "/sendEmail")
	public String sendEmail(@RequestBody ArrayList<Guest> guestList) {
		List<String> guestListEmailIds = new ArrayList<String>();
		for (Guest guest : guestList) {
			guestListEmailIds.add(guest.get_guestEmailId());
		}
		return emailService.sendMail(guestListEmailIds);
	}

	@GetMapping(value = "/sendHello")
	public String hello() {
		return "done";
	}
}
