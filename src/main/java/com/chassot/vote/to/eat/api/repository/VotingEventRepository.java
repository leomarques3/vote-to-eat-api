package com.chassot.vote.to.eat.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chassot.vote.to.eat.api.model.VotingEvent;

@Repository
public interface VotingEventRepository extends JpaRepository<VotingEvent, Long> {
	
	@Query(value = "SELECT v.restaurantName FROM VotingEvent v GROUP BY v.restaurantName ORDER BY COUNT(v.restaurantName) DESC")
	public List<String> findAllGroupedByVotes();

}
