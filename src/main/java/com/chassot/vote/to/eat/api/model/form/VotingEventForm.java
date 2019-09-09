package com.chassot.vote.to.eat.api.model.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.chassot.vote.to.eat.api.model.VotingEvent;

public class VotingEventForm {

	@NotNull
	@NotEmpty
	private String userId;

	@NotNull
	@NotEmpty
	private String restaurant;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public VotingEvent convertToDocument() {
		return new VotingEvent(userId, restaurant);
	}

}
