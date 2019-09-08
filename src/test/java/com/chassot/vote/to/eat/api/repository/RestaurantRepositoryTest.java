package com.chassot.vote.to.eat.api.repository;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chassot.vote.to.eat.api.model.Restaurant;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RestaurantRepositoryTest {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Test
	public void findByIsAvailableTest() {
		List<Restaurant> found = restaurantRepository.findByIsAvailable(true);
		
		assertThat(found, hasSize(6));
	}

}
