package com.partyplanner.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.partyplanner.models.EventDetails;

public interface AppRepository extends JpaRepository<EventDetails,Integer>{
	

}
