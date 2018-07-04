package com.partyplanner.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Guest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _guestListId;
	private String _guestEmailId;
	
	public int get_guestListId() {
		return _guestListId;
	}
	public void set_guestListId(int _guestListId) {
		this._guestListId = _guestListId;
	}
	public String get_guestEmailId() {
		return _guestEmailId;
	}
	public void set_guestEmailId(String _guestEmailId) {
		this._guestEmailId = _guestEmailId;
	}
	
}
