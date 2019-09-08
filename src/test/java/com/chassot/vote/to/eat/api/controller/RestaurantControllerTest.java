package com.chassot.vote.to.eat.api.controller;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.chassot.vote.to.eat.api.exception.ResourceNotFoundException;
import com.chassot.vote.to.eat.api.model.Restaurant;
import com.chassot.vote.to.eat.api.model.dto.RestaurantDto;
import com.chassot.vote.to.eat.api.service.RestaurantService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantControllerTest {

	@Autowired
	private RestaurantController restaurantController;

	@MockBean
	private RestaurantService restaurantService;

	@Test
	public void getAvailableRestaurantsTest() throws ResourceNotFoundException {
		Restaurant restaurant1 = new Restaurant("McDonalds", true);
		Restaurant restaurant2 = new Restaurant("Burguer King", true);
		List<Restaurant> restaurants = List.of(restaurant1, restaurant2);
		List<RestaurantDto> restrauntsDto = RestaurantDto.convertToListDto(restaurants);

		Mockito.when(restaurantService.getAvailableRestaurants()).thenReturn(restrauntsDto);
		ResponseEntity<List<RestaurantDto>> result = restaurantController.getAvailableRestaurants();
		assertEquals("Status code", HttpStatus.OK, result.getStatusCode());
	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void getAvailableRestaurantsExceptionTest() throws ResourceNotFoundException {
		List<RestaurantDto> restrauntsDto = Collections.emptyList();

		Mockito.when(restaurantService.getAvailableRestaurants()).thenReturn(restrauntsDto);
		restaurantController.getAvailableRestaurants();
	}

}
