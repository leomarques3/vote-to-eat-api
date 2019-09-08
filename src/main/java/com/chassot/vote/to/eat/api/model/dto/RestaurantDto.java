package com.chassot.vote.to.eat.api.model.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.chassot.vote.to.eat.api.model.Restaurant;

public class RestaurantDto {

	public String name;

	public RestaurantDto(Restaurant restaurant) {
		this.name = restaurant.getName();
	}

	public String getName() {
		return name;
	}

	public static List<RestaurantDto> convertToListDto(List<Restaurant> restaurants) {
		if (restaurants != null && !restaurants.isEmpty()) {
			return restaurants.stream().map(RestaurantDto::new).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

}
