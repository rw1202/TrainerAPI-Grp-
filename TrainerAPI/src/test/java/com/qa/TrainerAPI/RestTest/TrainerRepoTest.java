package com.qa.TrainerAPI.RestTest;




import java.util.Optional;
import static org.junit.Assert.assertEquals;
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
public class TrainerRepoTest {
	
	    private Optional<Trainee> aTrainee;
	
		@Autowired
		TestEntityManager entityManager;
		
		@Autowired
		TrainerRepository traineeRepo;
		
		@Test
		public void getReservation_returnReservationDetails() {
			
			Trainee traineeList = new Trainee();

			aTrainee = Optional.of(traineeList);

			aTrainee.get().setFirstName("firstName");
			aTrainee.get().setLastName("lastName");
			
			
			Trainee savedTrainee = entityManager.persistAndFlush(aTrainee.get());
			Optional<Trainee> foundTrainee = traineeRepo.findById(aTrainee.get().getTraineeId());
			
			assertEquals(savedTrainee, foundTrainee.get());
			
			
		}
	}

