package com.chassot.vote.to.eat.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chassot.vote.to.eat.api.exception.ResourceNotFoundException;
import com.chassot.vote.to.eat.api.model.dto.RestaurantDto;
import com.chassot.vote.to.eat.api.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/available")
	public ResponseEntity<List<RestaurantDto>> getAvailableRestaurants() throws ResourceNotFoundException {
		List<RestaurantDto> restaurants = restaurantService.getAvailableRestaurants();
		if (!restaurants.isEmpty()) {
			return ResponseEntity.ok(restaurants);
		}
		throw new ResourceNotFoundException("There are no available restaurants in the week");
	}

}
