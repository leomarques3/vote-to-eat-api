package com.chassot.vote.to.eat.api.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.chassot.vote.to.eat.api.model.VotingEvent;
import com.chassot.vote.to.eat.api.model.dto.VotingEventDto;
import com.chassot.vote.to.eat.api.model.form.VotingEventForm;
import com.chassot.vote.to.eat.api.service.VotingEventService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VotingEventControllerTest {

	@Autowired
	private VotingEventController votingEventController;

	@MockBean
	private VotingEventService votingEventService;

	@Test
	public void saveVoteTest() {
		VotingEventForm votingEventForm = new VotingEventForm();
		votingEventForm.setUserId("leo555");
		votingEventForm.setRestaurant("Batata");
		VotingEvent votingEvent = votingEventForm.convertToDocument();

		Mockito.when(votingEventService.saveVote(any(VotingEventForm.class))).thenReturn(votingEvent);
		ResponseEntity<VotingEventDto> result = votingEventController.saveVote(votingEventForm);
		assertEquals("Status code", HttpStatus.CREATED, result.getStatusCode());
	}

}
