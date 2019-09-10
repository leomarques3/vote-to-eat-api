package com.chassot.vote.to.eat.api.model.dto;

import com.chassot.vote.to.eat.api.model.VotingEvent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="VotingEvent - ResponseBody - saveVote", description="ResponseBody to be returned in the saveVote post method")
public class VotingEventDto {

	private String username;
	private String restaurantName;

	public VotingEventDto(VotingEvent votingEvent) {
		this.username = votingEvent.getUsername();
		this.restaurantName = votingEvent.getRestaurantName();
	}

	@ApiModelProperty(value = "User id that is currently voting", required = true)
	public String getUsername() {
		return username;
	}

	@ApiModelProperty(value = "Name of the chosen restaurant", required = true)
	public String getRestaurantName() {
		return restaurantName;
	}

}
