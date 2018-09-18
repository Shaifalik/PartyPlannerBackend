package com.partyplanner.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
        name = "event_details",
        uniqueConstraints = {
        		 @UniqueConstraint(columnNames = "_eventName")
        })
public class EventDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _eventId;
	private String _eventName;
	private String _eventDescription;
	private Date _eventDate;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_Id")
	private Set<Food> _foodList = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_Id")
	private Set<Guest> _guestList = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_Id")
	private Set<Location> _locationList = new HashSet<>();

	@OneToOne(cascade = CascadeType.ALL)
	private Budget _budget;

	public Set<Guest> get_guestList() {
		return _guestList;
	}

	public void set_guestList(Set<Guest> _guestList) {
		this._guestList = _guestList;
	}

	public Budget get_budget() {
		return _budget;
	}

	public void set_budget(Budget _budget) {
		this._budget = _budget;
	}

	public int get_eventId() {
		return _eventId;
	}

	public void set_eventId(int _eventId) {
		this._eventId = _eventId;
	}

	public String get_eventName() {
		return _eventName;
	}

	@Column(name = "Event_Name", unique = true, nullable = false)
	public void set_eventName(String _eventName) {
		this._eventName = _eventName;
	}

	public String get_eventDescription() {
		return _eventDescription;
	}

	@Column(name = "Event_Desc", nullable = false, length = 20)
	public void set_eventDescription(String _eventDescription) {
		this._eventDescription = _eventDescription;
	}

	public Date get_eventDate() {
		return _eventDate;
	}

	@Column(name = "Event_Date", unique = true, nullable = false)
	public void set_eventDate(Date _eventDate) {
		this._eventDate = _eventDate;
	}

	public Set<Food> get_foodList() {
		return _foodList;
	}

	public void set_foodList(Set<Food> _foodList) {
		this._foodList = _foodList;
	}

	public Set<Location> get_locationList() {
		return _locationList;
	}

	public void set_locationList(Set<Location> _locationList) {
		this._locationList = _locationList;
	}

}
