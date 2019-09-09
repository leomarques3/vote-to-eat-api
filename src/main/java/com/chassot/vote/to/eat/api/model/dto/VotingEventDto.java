package com.chassot.vote.to.eat.api.model.dto;

import com.chassot.vote.to.eat.api.model.VotingEvent;

public class VotingEventDto {

	private String username;
	private String restaurantName;

	public VotingEventDto(VotingEvent votingEvent) {
		this.username = votingEvent.getUsername();
		this.restaurantName = votingEvent.getRestaurantName();
	}

	public String getUsername() {
		return username;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

}
