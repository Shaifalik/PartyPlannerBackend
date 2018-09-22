package com.partyplanner.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.partyplanner.models.BudgetCategory;
import com.partyplanner.models.EventDetails;
import com.partyplanner.models.Food;
import com.partyplanner.models.Guest;
import com.partyplanner.repos.AppRepository;
import com.partyplanner.repos.BudgetCategoryRepository;
import com.partyplanner.models.Location;
import com.partyplanner.repos.FoodRepository;
import com.partyplanner.repos.GuestRepository;
import com.partyplanner.repos.LocationRepository;
import org.springframework.data.domain.Sort;

@Service
public class AppService {

	@Autowired
	private AppRepository appRepo;

	@Autowired
	private LocationRepository locRepo;

	@Autowired
	private FoodRepository foodRepo;

	@Autowired
	private GuestRepository guestRepo;

	@Autowired
	private BudgetCategoryRepository budgetRepo;

	public void persist(EventDetails eventData) {
		appRepo.save(eventData);
	}
	
	public void updateEventData(EventDetails eventData) {
		EventDetails oldData=appRepo.getOne(eventData.get_eventId());
		appRepo.delete(oldData);
		appRepo.save(eventData);
	}

	public void updateCategoryData(BudgetCategory ctgy) {
		BudgetCategory data = budgetRepo.getOne(ctgy.get_budgetCategoryId());
		data.set_budgetCategoryAmount(ctgy.get_budgetCategoryAmount());
		data.set_budgetCategoryName(ctgy.get_budgetCategoryName());
		budgetRepo.save(data);
	}

	public List<EventDetails> get() {
		List<EventDetails> evntDetail = appRepo.findAll(sortByIdDesc());
		return evntDetail;
	}
	private Sort sortByIdDesc() {
		return new Sort(Sort.Direction.DESC, "_eventId");
	}

	public Optional<EventDetails> getEventById(int id) {
		return appRepo.findById(id);
	}

	public List<Location> fetchLocationData() {
		return locRepo.findAll();
	}

	public List<Food> fetchFoodData() {
		return foodRepo.findAll();
	}

	public List<Guest> fetchGuestData() {
		return guestRepo.findAll();
	}

	public List<BudgetCategory> fetchCategoryData() {
		return budgetRepo.findAll();
	}

	public BudgetCategory fetchBudgetCategoryIdData(int id) {
		return budgetRepo.getOne(id);
	}

}
