package com.qa.TrainerAPI.RestTest;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.qa.TrainerAPI.persistence.domain.Trainee;
import com.qa.TrainerAPI.rest.TrainerEndpoint;
import com.qa.TrainerAPI.service.business.TrainerService;

public class TrainerEndpointTest {
	@InjectMocks
	private TrainerEndpoint trainerEndpoint;
	
	@Mock
	private TrainerService service;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addTrainee() {
		Trainee trainee= new Trainee();
		trainee.setFirstName("firstname");
		trainee.setLastName("lastname");
		trainee.setTraineeId(111);
		
		Trainee traineeToBeAdded = new Trainee();
		traineeToBeAdded.setFirstName("firstname");
		traineeToBeAdded.setLastName("lastName");
		traineeToBeAdded.setTraineeId(111);
		
		when(service.add(traineeToBeAdded)).thenReturn(trainee);
		Trainee addedTrainee = traineeEndpoint.addTrainee(traineeToBeAdded);
		assertEquals(addedTrainee, trainee);
	}
}
