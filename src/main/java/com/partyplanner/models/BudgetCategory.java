package com.partyplanner.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BudgetCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long _budgetCategoryId;
	private String _budgetCategoryName;
	private int _budgetCategoryAmount;
	
	public long get_budgetCategoryId() {
		return _budgetCategoryId;
	}
	public void set_budgetCategoryId(long _budgetCategoryId) {
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
