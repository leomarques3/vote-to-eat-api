package com.chassot.vote.to.eat.api.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.chassot.vote.to.eat.api.model.VotingEvent;
import com.chassot.vote.to.eat.api.model.form.VotingEventForm;
import com.chassot.vote.to.eat.api.repository.VotingEventRepository;
import com.chassot.vote.to.eat.api.service.VotingEventService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VotingEventServiceImplTest {

	@Autowired
	private VotingEventService votingEventService;

	@MockBean
	private VotingEventRepository votingEventRepository;

	@Test
	public void saveVoteTest() {
		VotingEventForm votingEventForm = new VotingEventForm();
		votingEventForm.setUserId("leo555");
		votingEventForm.setRestaurant("Batata");
		VotingEvent votingEvent = votingEventForm.convertToDocument();

		Mockito.when(votingEventRepository.save(any(VotingEvent.class))).thenReturn(votingEvent);
		VotingEvent saved = votingEventService.saveVote(votingEventForm);

		assertThat(saved, is(equalTo(votingEvent)));
	}

}
