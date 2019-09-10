package com.chassot.vote.to.eat.api.job.process;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chassot.vote.to.eat.api.model.Restaurant;
import com.chassot.vote.to.eat.api.repository.RestaurantRepository;

@Component
public class RestaurantProcess {

	@Autowired
	private RestaurantRepository restaurantRepository;

	public void process() {
		// Every weekend it will reset the available restaurants
		List<Restaurant> restaurants = restaurantRepository.findByIsAvailable(false);
		restaurants.forEach(r -> r.setIsAvailable(true));
		restaurantRepository.saveAll(restaurants);
	}

}
