package com.partyplanner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partyplanner.models.EventDetails;
import com.partyplanner.repos.AppRepository;

@Service
public class AppService {
	
	@Autowired
	private AppRepository AppRepo;
	
	public void persist(EventDetails eventData) {
		AppRepo.save(eventData);
		System.out.println(AppRepo.findAll());;
	}
}
