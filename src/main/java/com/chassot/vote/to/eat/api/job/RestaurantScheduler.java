package com.chassot.vote.to.eat.api.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.chassot.vote.to.eat.api.job.process.RestaurantProcess;

@Component
@EnableScheduling
public class RestaurantScheduler {

	private static final String TIME_ZONE = "America/Sao_Paulo";
	private static final String CRON = "0 0 9 * * 6";

	@Autowired
	private RestaurantProcess restaurantProcess;

	@Scheduled(cron = CRON, zone = TIME_ZONE)
	public void process() {
		restaurantProcess.process();
	}

}
