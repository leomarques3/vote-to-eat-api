package com.chassot.vote.to.eat.api.service;

import com.chassot.vote.to.eat.api.model.VotingEvent;
import com.chassot.vote.to.eat.api.model.form.VotingEventForm;

public interface VotingEventService {
	
	public VotingEvent saveVote(VotingEventForm votingEventForm);

}
