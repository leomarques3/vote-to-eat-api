package com.chassot.vote.to.eat.api.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chassot.vote.to.eat.api.model.VotingUser;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VotingUserRepositoryTest {

	@Autowired
	private VotingUserRepository votingUserRepository;

	@Test
	public void findByUsernameTest() {
		VotingUser found = votingUserRepository.findByUsername("leo2");

		assertThat(found.getUsername(), is(equalTo("leo2")));
	}

}
