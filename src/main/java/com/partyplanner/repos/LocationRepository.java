package com.partyplanner.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.partyplanner.models.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
