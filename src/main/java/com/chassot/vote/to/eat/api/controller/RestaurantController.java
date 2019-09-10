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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/restaurant")
@Api(value = "Restaurant Management API")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@ApiOperation(value = "View a list of available restaurants in the week")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved the list"),
			@ApiResponse(code = 404, message = "There are no available restaurants in the week") })
	@GetMapping("/available")
	public ResponseEntity<List<RestaurantDto>> getAvailableRestaurants() throws ResourceNotFoundException {
		List<RestaurantDto> restaurants = restaurantService.getAvailableRestaurants();
		if (!restaurants.isEmpty()) {
			return ResponseEntity.ok(restaurants);
		}
		throw new ResourceNotFoundException("There are no available restaurants in the week");
	}

}
