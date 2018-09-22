package com.partyplanner.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BudgetCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _budgetCategoryId;
	private String _budgetCategoryName;
	private int _budgetCategoryAmount;
	
	public int get_budgetCategoryId() {
		return _budgetCategoryId;
	}
	public void set_budgetCategoryId(int _budgetCategoryId) {
		this._budgetCategoryId = _budgetCategoryId;
	}
	
	public int get_budgetCategoryAmount() {
		return _budgetCategoryAmount;
	}
	public void set_budgetCategoryAmount(int _budgetCategoryAmount) {
		this._budgetCategoryAmount = _budgetCategoryAmount;
	}
	public String get_budgetCategoryName() {
		return _budgetCategoryName;
	}
	public void set_budgetCategoryName(String _budgetCategoryName) {
		this._budgetCategoryName = _budgetCategoryName;
	}
	
}
