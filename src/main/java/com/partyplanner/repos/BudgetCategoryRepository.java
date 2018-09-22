package com.partyplanner.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.partyplanner.models.BudgetCategory;

public interface BudgetCategoryRepository extends JpaRepository<BudgetCategory, Integer> {

}
