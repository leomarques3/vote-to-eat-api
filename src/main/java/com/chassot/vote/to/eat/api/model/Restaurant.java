package com.chassot.vote.to.eat.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String name;

	private Boolean isAvailable;

	public Restaurant() {
	}

	public Restaurant(String name, Boolean isAvailable) {
		this.name = name;
		this.isAvailable = isAvailable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	@Override
	public String toString() {
		return String.format("Restaurant[name='%s', isAvailable='%s']", name, isAvailable);
	}

}
