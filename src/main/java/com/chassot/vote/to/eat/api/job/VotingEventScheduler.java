package com.chassot.vote.to.eat.api.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class VotingEventScheduler {
	
	private static final String TIME_ZONE = "America/Sao_Paulo";
	private static final String CRON = "0 30 11 * * *";
	
	@Autowired
	private VotingEventProcess votingEventProcess;
	
	@Scheduled(cron = CRON, zone = TIME_ZONE)
	public void process() {
		votingEventProcess.process();
	}

}
