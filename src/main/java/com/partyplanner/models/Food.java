package com.partyplanner.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _foodId;
	private String _foodItem;
	
	public int get_foodId() {
		return _foodId;
	}
	public void set_foodId(int _foodId) {
		this._foodId = _foodId;
	}
	public String get_foodItem() {
		return _foodItem;
	}
	public void set_foodItem(String _foodItem) {
		this._foodItem = _foodItem;
	}

}
