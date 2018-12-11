package com.qa.TrainerAPI.RestTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import com.qa.TrainerAPI.persistence.domain.Trainer;
import com.qa.TrainerAPI.rest.TrainerEndpoint;
import com.qa.TrainerAPI.service.business.TrainerService;

@RunWith(SpringRunner.class)

public class EndpointTest {

	@Mock
	TrainerService service;

	@InjectMocks
	private TrainerEndpoint endpoints;

	@Test
	public void endPointTests_GetAll() {
		ArrayList<Trainer> trainerList = new ArrayList<Trainer>();
		Trainer trainer1 = new Trainer();

		trainerList.add(trainer1);
		trainerList.add(trainer1);

		Mockito.when(service.getAll()).thenReturn((List<Trainer>) trainerList);

		Assert.assertEquals(endpoints.getAllTrainers(), trainerList);
	}
	
	@Test
	public void endPointTests_Get() {
		ArrayList<Trainer> trainerList = new ArrayList<Trainer>();
		Trainer trainer1 = new Trainer();
		Trainer trainer2 = new Trainer();
		
		trainer1.setFirstName("Rob");
		trainer1.setLastName("Last");
		trainer1.setUsername("rob@mail.com");

		trainerList.add(trainer1);
		trainerList.add(trainer2);
		Mockito.when(service.get("rob@mail.com")).thenReturn(Optional.of(trainer1));
		Assert.assertEquals(endpoints.getTrainer("rob@mail.com"), Optional.of(trainer1));
		
	}
	
	@Test
	public void endPointTests_Delete() {
		ArrayList<Trainer> trainerList = new ArrayList<Trainer>();
		Trainer trainer1 = new Trainer();
		Trainer trainer2 = new Trainer();
		
		trainer1.setFirstName("Rob");
		trainer1.setLastName("Last");
		trainer1.setUsername("rob@mail.com");

		trainerList.add(trainer1);
		trainerList.add(trainer2);
		Mockito.when(service.get("rob@mail.com")).thenReturn(Optional.of(trainer1));
		Assert.assertEquals(endpoints.getTrainer("rob@mail.com"), Optional.of(trainer1));
		
	}
	
	

}
