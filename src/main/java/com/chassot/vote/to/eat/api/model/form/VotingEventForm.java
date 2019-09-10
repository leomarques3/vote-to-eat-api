package com.chassot.vote.to.eat.api.model.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.chassot.vote.to.eat.api.model.VotingEvent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="VotingEvent - RequestBody - saveVote", description="RequestBody to be used in the saveVote post method")
public class VotingEventForm {

	@NotNull
	@NotEmpty
	private String userId;

	@NotNull
	@NotEmpty
	private String restaurant;

	@ApiModelProperty(value = "User id that is currently voting", required = true)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@ApiModelProperty(value = "Name of the chosen restaurant", required = true)
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
