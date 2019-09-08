package com.chassot.vote.to.eat.api.service.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.chassot.vote.to.eat.api.model.Restaurant;
import com.chassot.vote.to.eat.api.model.dto.RestaurantDto;
import com.chassot.vote.to.eat.api.repository.RestaurantRepository;
import com.chassot.vote.to.eat.api.service.RestaurantService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceImplTest {

	@Autowired
	private RestaurantService restaurantService;

	@MockBean
	private RestaurantRepository restaurantRepository;

	@Test
	public void getAvailableRestaurantsTest() {
		Restaurant restaurant1 = new Restaurant("McDonalds", true);
		Restaurant restaurant2 = new Restaurant("Burguer King", true);
		List<Restaurant> restaurants = List.of(restaurant1, restaurant2);

		Mockito.when(restaurantRepository.findByIsAvailable(true)).thenReturn(restaurants);
		List<RestaurantDto> restaurantsDto = restaurantService.getAvailableRestaurants();
		assertThat(restaurantsDto, hasSize(2));
	}

	@Test
	public void getAvailableRestaurantsEmptyTest() {
		List<Restaurant> restaurants = new ArrayList<>();

		Mockito.when(restaurantRepository.findByIsAvailable(true)).thenReturn(restaurants);
		List<RestaurantDto> restaurantsDto = restaurantService.getAvailableRestaurants();
		assertThat(restaurantsDto, is(empty()));
	}

	@Test
	public void getAvailableRestaurantsNullTest() {
		List<Restaurant> restaurants = null;

		Mockito.when(restaurantRepository.findByIsAvailable(true)).thenReturn(restaurants);
		List<RestaurantDto> restaurantsDto = restaurantService.getAvailableRestaurants();
		assertThat(restaurantsDto, is(empty()));
	}

}
