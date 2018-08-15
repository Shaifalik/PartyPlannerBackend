package com.partyplanner.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.partyplanner.models.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {

}
