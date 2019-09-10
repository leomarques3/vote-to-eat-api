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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/vote")
@Api(value = "Voting system API")
public class VotingEventController {

	@Autowired
	private VotingEventService votingEventService;

	@ApiOperation(value = "Save the restaurant chosen by the user")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved the restaurant") })
	@PostMapping("/save")
	public ResponseEntity<VotingEventDto> saveVote(@RequestBody @Valid VotingEventForm votingEventForm) {
		VotingEvent votingEvent = votingEventService.saveVote(votingEventForm);
		return new ResponseEntity<>(new VotingEventDto(votingEvent), HttpStatus.CREATED);
	}

}
