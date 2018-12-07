package com.qa.TrainerAPI.RestTest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import com.qa.TrainerAPI.persistence.domain.Trainee;
import com.qa.TrainerAPI.persistence.repository.TrainerRepository;

@RunWith(SpringRunner.class)


public class EndToEndTest {

	private Optional<Trainee> aTrainee;
	@MockBean
	@Autowired
	TestRestTemplate testRestTemplate;
	@Mock
	private TrainerRepository traineeRepo;

	@Test
	public void getTrainee_shouldGetTrainee()throws IOException {
		// Arrange
		Trainee traineeList = new Trainee();
		aTrainee = Optional.of(traineeList);

		aTrainee.get().setFirstName("firstName");
		aTrainee.get().setLastName("lastName");

		traineeRepo.save(aTrainee.get());
		System.out.println(traineeRepo.count());

		// Act
		TestRestTemplate testRestTemplate = new TestRestTemplate();

		ResponseEntity<Trainee> response = testRestTemplate.getForEntity("http://localhost:8081/trainee/getTrainee/{Id}", Trainee.class,
				aTrainee.get().getTraineeId());
		Trainee response2 = testRestTemplate.getForObject("/trainee/getTrainee/{Id}", Trainee.class,
				aTrainee.get().getTraineeId());

		// Assert
		System.out.println("test");

		System.out.println(response);
		System.out.println(response2);
		assertEquals(response.getBody().getTraineeId(), aTrainee.get().getTraineeId());

	}

	@Component
	class SampleData implements CommandLineRunner {
		private TrainerRepository traineeRepo;

		public SampleData(TrainerRepository traineeRepo) {
			this.traineeRepo = traineeRepo;
		}

		@Override
		public void run(String... args) throws Exception {
			System.out.println("@@@@@@@@@@@@@@ Entering SampleDataCLR : run");
			Trainee traineeList = new Trainee();
			aTrainee = Optional.of(traineeList);

			aTrainee.get().setFirstName("firstName");
			aTrainee.get().setLastName("lastName");
			aTrainee.get().setTraineeId(111l);
			traineeRepo.save(aTrainee.get());

			traineeRepo.findAll().forEach(System.out::println);
			System.out.println("@@@@@@@@@@@@@@ Leaving SampleDataCLR : run");
		}
	}

}