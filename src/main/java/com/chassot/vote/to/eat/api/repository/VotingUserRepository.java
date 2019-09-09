package com.chassot.vote.to.eat.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chassot.vote.to.eat.api.model.VotingUser;

@Repository
public interface VotingUserRepository extends JpaRepository<VotingUser, Long> {
	
	public VotingUser findByUsername(String username);

}
