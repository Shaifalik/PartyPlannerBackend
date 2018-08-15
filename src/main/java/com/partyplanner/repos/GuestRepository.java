package com.partyplanner.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.partyplanner.models.Guest;

public interface GuestRepository extends JpaRepository<Guest, Integer> {

}
