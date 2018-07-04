package com.partyplanner.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.partyplanner.models.EventDetails;

public interface AppRepository extends JpaRepository<EventDetails,Integer>{

}
