package com.chassot.vote.to.eat.api.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WinnerHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String restaurant;
	private LocalDate chosenDate;
	
	public WinnerHistory() {
	}
	
	public WinnerHistory(String restaurant, LocalDate chosenDate) {
		super();
		this.restaurant = restaurant;
		this.chosenDate = chosenDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public LocalDate getChosenDate() {
		return chosenDate;
	}

	public void setChosenDate(LocalDate chosenDate) {
		this.chosenDate = chosenDate;
	}

}
