package com.partyplanner.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.partyplanner.models.BudgetCategory;

public interface CategoryRepository extends JpaRepository<BudgetCategory, Long> {

}
