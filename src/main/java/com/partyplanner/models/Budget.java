package com.partyplanner.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Budget {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _budgetId;
	
	private int _budgetCategoryId;
	
	private int _totalExpense;
	private int _totalQuantity;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "budget_Id")
	private Set<Expense> _expenseList=new HashSet<>();
	
	public int get_budgetId() {
		return _budgetId;
	}

	public void set_budgetId(int _budgetId) {
		this._budgetId = _budgetId;
	}

	public int get_budgetCategory() {
		return _budgetCategoryId;
	}

	public void set_budgetCategoryId(int _budgetCategory) {
		this._budgetCategoryId = _budgetCategory;
	}

	public int get_totalExpense() {
		return _totalExpense;
	}

	public void set_totalExpense(int _totalExpense) {
		this._totalExpense = _totalExpense;
	}

	public int get_totalQuantity() {
		return _totalQuantity;
	}

	public void set_totalQuantity(int _totalQuantity) {
		this._totalQuantity = _totalQuantity;
	}

	public Set<Expense> get_expenseList() {
		return _expenseList;
	}

	public void set_expenseList(Set<Expense> _expenseList) {
		this._expenseList = _expenseList;
	}	

}
