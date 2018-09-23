package com.partyplanner.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	public String createEvent(@RequestBody String json) throws Exception {
		EventDetails eventData;
		try {
			eventData = new ObjectMapper().readValue(json, EventDetails.class);
			appService.persist(eventData);
			return "Saved Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error Ocurred while Saving");
		}
	}

	@PostMapping(value = "/updateEventDetailData")
	public String updateEventDetailData(@RequestBody String json) throws Exception {
		EventDetails eventData;
		try {
			eventData = new ObjectMapper().readValue(json, EventDetails.class);
			appService.updateEventData(eventData);
			return "Saved Successfully";
		} catch (DataIntegrityViolationException ex) {
			ex.printStackTrace();
			throw new Exception("EventId should be unique");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@PostMapping(value = "/updateBudgetCategoryData")
	public void updateBudgetCategoryData(@RequestBody String jsonData) {
		BudgetCategory ctgy;
		try {
			ctgy = new ObjectMapper().readValue(jsonData, BudgetCategory.class);
			appService.updateCategoryData(ctgy);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/sendEmail/{eventId}")
	public String sendEmail(@RequestBody ArrayList<Guest> guestList, @PathVariable int eventId) {
		List<String> guestListEmailIds = new ArrayList<String>();
		for (Guest guest : guestList) {
			guestListEmailIds.add(guest.get_guestEmailId());
		}
		return emailService.sendMail(guestListEmailIds, eventId);
	}

	@GetMapping(value = "/fetchLocationList")
	public Set<String> fetchLocationList() {
		Set<String> locNames = new HashSet<String>();
		for (Location loc : appService.fetchLocationData()) {
			locNames.add(loc.get_eventLocation());
		}
		return locNames;
	}

	@GetMapping(value = "/fetchFoodList")
	public Set<String> fetchFoodList() {
		Set<String> foodItems = new HashSet<String>();
		for (Food food : appService.fetchFoodData()) {
			foodItems.add(food.get_foodItem());
		}
		return foodItems;
	}

	@GetMapping(value = "/fetchGuestList")
	public Set<String> fetchGuestList() {
		Set<String> guestEmailIds = new HashSet<String>();
		for (Guest guest : appService.fetchGuestData()) {
			guestEmailIds.add(guest.get_guestEmailId());
		}
		return guestEmailIds;
	}

	@GetMapping(value = "/fetchBudgetCategory")
	public List<BudgetCategory> fetchBudgetCategory() {
		return appService.fetchCategoryData();
	}

	@GetMapping(value = "/fetchBudgetCategoryIdData/{budCtgy}")
	public BudgetCategory fetchBudgetCategoryData(@PathVariable int budCtgy) {
		return appService.fetchBudgetCategoryIdData(budCtgy);
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

}
