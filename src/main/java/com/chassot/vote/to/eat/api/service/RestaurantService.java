package com.chassot.vote.to.eat.api.service;

import java.util.List;

import com.chassot.vote.to.eat.api.model.dto.RestaurantDto;

public interface RestaurantService {

	public List<RestaurantDto> getAvailableRestaurants();

}
