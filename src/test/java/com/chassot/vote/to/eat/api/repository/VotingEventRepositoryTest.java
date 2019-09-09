package com.chassot.vote.to.eat.api.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chassot.vote.to.eat.api.model.VotingEvent;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VotingEventRepositoryTest {

	@Autowired
	private VotingEventRepository votingEventRepository;

	@Test
	public void findByUsernameTest() {
		VotingEvent votingEvent = new VotingEvent("leo99999", "Batata");
		VotingEvent saved = votingEventRepository.save(votingEvent);
		assertThat(saved, is(equalTo(votingEvent)));
	}
	
	@Test
	public void findAllGroupedByVotesTest() {
		List<String> votes = votingEventRepository.findAllGroupedByVotes();
		System.out.println(votes.toString());
	}

}
