package com.chassot.vote.to.eat.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chassot.vote.to.eat.api.model.VotingEvent;
import com.chassot.vote.to.eat.api.model.dto.VotingEventDto;
import com.chassot.vote.to.eat.api.model.form.VotingEventForm;
import com.chassot.vote.to.eat.api.service.VotingEventService;

@RestController
@RequestMapping("/vote")
public class VotingEventController {
	
	@Autowired
	private VotingEventService votingEventService;
	
	@PostMapping("/save")
	public ResponseEntity<VotingEventDto> saveVote(@RequestBody @Valid VotingEventForm votingEventForm) {
		VotingEvent votingEvent = votingEventService.saveVote(votingEventForm);
		return new ResponseEntity<>(new VotingEventDto(votingEvent), HttpStatus.CREATED);
	}

}
