package com.qa.TrainerAPI.RestTest;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import com.qa.TrainerAPI.persistence.domain.Trainee;
import com.qa.TrainerAPI.rest.TrainerEndpoint;
import com.qa.TrainerAPI.service.business.TrainerService;



@RunWith(MockitoJUnitRunner.class)
public class TrainerEndpointTest {
	
	
	public Trainee trainee;
	public List<Trainee> traineeList;
	
	@InjectMocks
	private TrainerEndpoint trainerEndpoint;
	
	@Mock
	private TrainerService service;
	
	@Before
	public void add(){
	trainee = new Trainee("firstName", "lastName", (111l));
	traineeList = new ArrayList<Trainee>();
	traineeList.add(trainee);
	}	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	

	
		@Test
		public void getTraineeTest() {
			when(service.get(111l)).thenReturn(trainee);
			assertEquals(traineeList.get(0), service.get(111l));
		
		}
	
	}

