package com.qa.TrainerAPI.RestTest;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.qa.TrainerAPI.persistence.domain.Trainee;
import com.qa.TrainerAPI.rest.TrainerEndpoint;
import com.qa.TrainerAPI.service.business.TraineeService;

@RunWith(SpringRunner.class)
@WebMvcTest(TrainerEndpoint.class)
public class RestControllerTest {

	private Iterable<Trainee> traineeList;
	private Optional<Trainee> trainee;
	private Optional<Trainee> aTrainee;


	@MockBean
	TraineeService service;

	@Before
	public void start() {

		
		Trainee traineeList = new Trainee();
		aTrainee = Optional.of(traineeList);

		aTrainee.get().setFirstName("secondName");
		aTrainee.get().setLastName("penultimateName");
		aTrainee.get().setTraineeId(112l);

		
		trainee = Optional.of(traineeList);

		trainee.get().setFirstName("firstName");
		trainee.get().setLastName("LastName");
		trainee.get().setTraineeId(111l);

	}

	@Test
	public void getTrainee_shouldReturnTrainee() {
		BDDMockito.given(service.get(111l)).willReturn(trainee);


}
	
	@Test
	public void getAllTrainees_shouldReturnAllTrainees() {
		
		BDDMockito.given(service.getAll()).willReturn((Iterable<Trainee>) traineeList);
	}
	
	
	
	
	
	
	
	
	}