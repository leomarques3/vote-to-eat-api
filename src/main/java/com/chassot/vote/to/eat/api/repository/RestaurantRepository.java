package com.chassot.vote.to.eat.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chassot.vote.to.eat.api.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

	public List<Restaurant> findByIsAvailable(Boolean isAvailable);
	
	public Restaurant findByName(String name);

}
