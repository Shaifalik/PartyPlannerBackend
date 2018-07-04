package com.partyplanner.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int expenseId;
	private String _food;
	private int _amount;
	private int _quantity;

	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	
	public int get_amount() {
		return _amount;
	}

	public void set_amount(int _amount) {
		this._amount = _amount;
	}

	public int get_quantity() {
		return _quantity;
	}

	public void set_quantity(int _quantity) {
		this._quantity = _quantity;
	}

	public String get_food() {
		return _food;
	}

	public void set_food(String _food) {
		this._food = _food;
	}

}
