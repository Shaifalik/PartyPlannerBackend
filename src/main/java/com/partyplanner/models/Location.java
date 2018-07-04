package com.partyplanner.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _locationId;
	private String _eventLocation;
	private String _eventAddress;

	public int get_locationId() {
		return _locationId;
	}
	
	@Column(name = "Location_Id")
	public void set_locationId(int _locationId) {
		this._locationId = _locationId;
	}
	
	public String get_eventLocation() {
		return _eventLocation;
	}
	
	@Column(name = "Location_Name", unique = true, nullable = false)
	public void set_eventLocation(String _eventLocation) {
		this._eventLocation = _eventLocation;
	}
	
	public String get_eventAddress() {
		return _eventAddress;
	}
	
	@Column(name = "Location_Address", unique = true, nullable = false)
	public void set_eventAddress(String _eventAddress) {
		this._eventAddress = _eventAddress;
	}
	

}
