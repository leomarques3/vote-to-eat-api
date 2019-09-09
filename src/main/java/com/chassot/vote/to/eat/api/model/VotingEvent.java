package com.chassot.vote.to.eat.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VotingEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String username;

	private String restaurantName;

	public VotingEvent() {
	}

	public VotingEvent(String username, String restaurantName) {
		this.username = username;
		this.restaurantName = restaurantName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	@Override
	public String toString() {
		return String.format("VotingEvent[id='%s', username='%s', restaurantName='%s]", id, username, restaurantName);
	}

}
