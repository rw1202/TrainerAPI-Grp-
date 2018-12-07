package com.qa.TrainerAPI.RestTest;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.TrainerAPI.persistence.domain.Trainee;
import com.qa.TrainerAPI.persistence.repository.TraineeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EndToEndTest {
	private Iterable<Trainee> traineeList;
	private Optional<Trainee> aTrainee;
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	public void getTrainee_shouldGetTrainee() {
		// Arrange
		
		// Act
		ResponseEntity<Trainee> response = testRestTemplate.getForEntity("/trainee/{Id}", Trainee.class, 111l);
		
		// Assert
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody().getTraineeId()).isEqualTo("111l");
		Assertions.assertThat(response.getBody().getTraineeId()).isNotNull();
}
	@Component
	class SampleData implements CommandLineRunner{
		private TraineeRepository traineeRepo;
		
		public SampleData(TraineeRepository traineeRepo) {
			this.traineeRepo=traineeRepo;
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
			
			traineeRepo.findAll().forEach(System.out :: println);
			System.out.println("@@@@@@@@@@@@@@ Leaving SampleDataCLR : run");
		}
	}
	
	
	
}