package com.chassot.vote.to.eat.api.job.process;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.chassot.vote.to.eat.api.model.Restaurant;
import com.chassot.vote.to.eat.api.repository.RestaurantRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantProcessTest {
	
	@Autowired
	private RestaurantProcess restaurantProcess;
	
	@MockBean
	private RestaurantRepository restaurantRepository;
	
	@Test
	public void processTest() {
		Restaurant restaurant1 = new Restaurant("Test1", false);
		Restaurant restaurant2 = new Restaurant("Test2", false);
		List<Restaurant> restaurants = List.of(restaurant1, restaurant2);
		Mockito.when(restaurantRepository.findByIsAvailable(anyBoolean())).thenReturn(restaurants);
		restaurants.forEach(r -> r.setIsAvailable(true));
		Mockito.when(restaurantRepository.saveAll(any())).thenReturn(restaurants);
		restaurantProcess.process();
	}

}
