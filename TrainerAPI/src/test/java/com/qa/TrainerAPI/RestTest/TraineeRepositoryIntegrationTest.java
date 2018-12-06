package com.qa.TrainerAPI.RestTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.TrainerAPI.persistence.domain.Trainee;
import com.qa.TrainerAPI.persistence.repository.TrainerRepository;


	@RunWith(SpringRunner.class)
	@DataJpaTest
	public class TraineeRepositoryIntegrationTest {

		@Autowired
		private TestEntityManager entityManager;

		@Autowired
		private TrainerRepository trainerRepo;

		@Autowired
		private Trainee trainee;

		@Test
		public void whenFindById() {
			// given
			trainee = new Trainee();
			trainee.setFirstName("firstName");
			trainee.setLastName("lastName");
			trainee.setTraineeId(111l);
			entityManager.persist(trainee);
			entityManager.flush();
			// when
			Optional<Trainee> found = trainerRepo.findById(111l);

			// then
			assertEquals((found.get().getTraineeId()), trainee.getTraineeId());
		}
	}


