package com.chassot.vote.to.eat.api.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chassot.vote.to.eat.api.model.VotingEvent;
import com.chassot.vote.to.eat.api.model.form.VotingEventForm;
import com.chassot.vote.to.eat.api.repository.VotingEventRepository;
import com.chassot.vote.to.eat.api.service.VotingEventService;

@Service
public class VotingEventServiceImpl implements VotingEventService {
	
	@Autowired
	private VotingEventRepository votingEventRepository;

	@Transactional
	@Override
	public VotingEvent saveVote(VotingEventForm votingEventForm) {
		VotingEvent votingEvent = votingEventForm.convertToDocument();
		return votingEventRepository.save(votingEvent);
	}

}
