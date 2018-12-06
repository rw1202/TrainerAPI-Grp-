package com.qa.TrainerAPI.RestTest;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
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
import com.qa.TrainerAPI.service.business.TraineeService;
import com.qa.TrainerAPI.service.business.TraineeServiceImpl;




@RunWith(MockitoJUnitRunner.class)
public class TrainerEndpointTest {
	
	
	public Trainee trainee;
	public ArrayList<Trainee> traineeList;
	
	

	
	@InjectMocks
	private TraineeServiceImpl service;
	
	@Before
	public void add(){
	trainee = new Trainee();
	trainee.setFirstName("firstName");
	trainee.setLastName("lastName");
	trainee.setTraineeId(111l);
	traineeList = new ArrayList<Trainee>();
	traineeList.add(trainee);
	
	}	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
//	@Before
//	public void manual() {
//
//		System.out.println(traineeList.get(0).toString());
//		System.out.println(service.get(111l));
//	}
	
		@Test
		public void getTraineeTest() {
			System.out.println(service.get(111l));
			assertEquals(traineeList.get(0).toString(), service.get(111l).toString());
		
		} 
	
	}

