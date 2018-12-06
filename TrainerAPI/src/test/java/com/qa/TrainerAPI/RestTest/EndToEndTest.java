package com.qa.TrainerAPI.RestTest;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.TrainerAPI.persistence.domain.Trainee;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EndToEndTest {
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	public void getReservation_shouldReturnReservationDetails() {
		// Arrange
		
		// Act
		ResponseEntity<Trainee> response = testRestTemplate.getForEntity("/trainee/{Id}", Trainee.class, 111l);
		
		// Assert
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	
		Assertions.assertThat(response.getBody().getTraineeId()).isNotNull();
}
}