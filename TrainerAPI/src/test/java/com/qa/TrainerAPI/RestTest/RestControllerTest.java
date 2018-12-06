package com.qa.TrainerAPI.RestTest;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.qa.TrainerAPI.persistence.domain.Trainee;
import com.qa.TrainerAPI.rest.TrainerEndpoint;
import com.qa.TrainerAPI.service.business.TraineeService;

@RunWith(SpringRunner.class)
@WebMvcTest(TrainerEndpoint.class)
public class RestControllerTest {

	private Optional<Trainee> trainee;


	@MockBean
	TraineeService service;

	@Before
	public void start() {

		
		Trainee traineeList = new Trainee();

		trainee = Optional.of(traineeList);

		trainee.get().setFirstName("firstName");
		trainee.get().setLastName("LastName");
		trainee.get().setTraineeId(111l);

	}

	@Test
	public void getTrainee_shouldReturnTrainee() {
		BDDMockito.given(service.get(111l)).willReturn(trainee);


}
	}