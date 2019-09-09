package com.chassot.vote.to.eat.api.job;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chassot.vote.to.eat.api.model.WinnerHistory;
import com.chassot.vote.to.eat.api.repository.VotingEventRepository;
import com.chassot.vote.to.eat.api.repository.WinnerHistoryRepository;

@Component
public class VotingEventProcess {
	
	@Autowired
	private VotingEventRepository votingEventRepository;
	
	@Autowired
	private WinnerHistoryRepository winnerHistoryRepository;
	
	@Transactional
	public void process() {
		String highestVote = votingEventRepository.findAllGroupedByVotes().get(0);
		WinnerHistory winnerHistory = new WinnerHistory(highestVote, LocalDate.now());
		winnerHistoryRepository.save(winnerHistory);
		votingEventRepository.deleteAll();
	}

}
