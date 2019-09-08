package com.chassot.vote.to.eat.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chassot.vote.to.eat.api.model.Restaurant;
import com.chassot.vote.to.eat.api.model.dto.RestaurantDto;
import com.chassot.vote.to.eat.api.repository.RestaurantRepository;
import com.chassot.vote.to.eat.api.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	private static final Boolean IS_AVAILABLE = true;
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public List<RestaurantDto> getAvailableRestaurants() {
		List<Restaurant> restaurants = restaurantRepository.findByIsAvailable(IS_AVAILABLE);
		return RestaurantDto.convertToListDto(restaurants);
	}

}
