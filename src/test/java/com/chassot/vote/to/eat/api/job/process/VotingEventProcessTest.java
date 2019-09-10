package com.chassot.vote.to.eat.api.job.process;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.chassot.vote.to.eat.api.model.Restaurant;
import com.chassot.vote.to.eat.api.model.WinnerHistory;
import com.chassot.vote.to.eat.api.repository.RestaurantRepository;
import com.chassot.vote.to.eat.api.repository.VotingEventRepository;
import com.chassot.vote.to.eat.api.repository.WinnerHistoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VotingEventProcessTest {

	@Autowired
	private VotingEventProcess votingEventProcess;

	@MockBean
	private VotingEventRepository votingEventRepository;

	@MockBean
	private WinnerHistoryRepository winnerHistoryRepository;

	@MockBean
	private RestaurantRepository restaurantRepository;

	@Test
	public void processTest() {
		String highestVote = "Madero";
		String other = "Panorama";
		List<String> restaurantsNames = List.of(highestVote, other);
		WinnerHistory winnerHistory = new WinnerHistory(highestVote, LocalDate.now());
		Restaurant restaurant = new Restaurant(highestVote, true);
		Mockito.when(votingEventRepository.findAllGroupedByVotes()).thenReturn(restaurantsNames);
		Mockito.when(winnerHistoryRepository.save(any())).thenReturn(winnerHistory);
		Mockito.when(restaurantRepository.findByName(anyString())).thenReturn(restaurant);
		doNothing().when(votingEventRepository).deleteAll();
		votingEventProcess.process();
	}

}
