package com.chassot.vote.to.eat.api.job.process;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chassot.vote.to.eat.api.model.Restaurant;
import com.chassot.vote.to.eat.api.model.WinnerHistory;
import com.chassot.vote.to.eat.api.repository.RestaurantRepository;
import com.chassot.vote.to.eat.api.repository.VotingEventRepository;
import com.chassot.vote.to.eat.api.repository.WinnerHistoryRepository;

@Component
public class VotingEventProcess {

	@Autowired
	private VotingEventRepository votingEventRepository;

	@Autowired
	private WinnerHistoryRepository winnerHistoryRepository;

	@Autowired
	private RestaurantRepository restaurantRepository;

	public void process() {
		// Get winner restaurant and save it
		String highestVote = votingEventRepository.findAllGroupedByVotes().get(0);
		WinnerHistory winnerHistory = new WinnerHistory(highestVote, LocalDate.now());
		winnerHistoryRepository.save(winnerHistory);

		// Update the winner restaurant. It can only be available next week
		Restaurant restaurant = restaurantRepository.findByName(winnerHistory.getRestaurant());
		restaurant.setIsAvailable(false);

		// Deleting all the votes of the day
		votingEventRepository.deleteAll();
	}

}
