package com.qa.TrainerAPI.RestTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.qa.TrainerAPI.persistence.domain.Trainee;
import com.qa.TrainerAPI.persistence.repository.TraineeRepository;
import com.qa.TrainerAPI.service.business.TraineeServiceImpl;





@RunWith(MockitoJUnitRunner.class)
public class TrainerServiceTest {
	@InjectMocks
	TraineeServiceImpl service;

	private Optional<Trainee> aTrainee;
	private Optional<Trainee> bTrainee;

	@Mock
	TraineeRepository traineeRepo;

	@Before
	public void set() throws Exception {

	}

	@Test
	public void getTrainee_returnsTrainee() {
		Trainee traineeList = new Trainee();

		aTrainee = Optional.of(traineeList);

		aTrainee.get().setFirstName("firstName");
		aTrainee.get().setLastName("lastName");
		aTrainee.get().setTraineeId(111l);
		

		Mockito.when(traineeRepo.findById(111l)).thenReturn(aTrainee);
		

		Assert.assertEquals(service.get(111l).get().getTraineeId(), aTrainee.get().getTraineeId());
		
	}
	
	@Test
	public void getAllTrainees_returnsAllTrainees() {
		List<Trainee> traineeList1 = new ArrayList();
		Trainee traineeList = new Trainee();

		aTrainee = Optional.of(traineeList);

		aTrainee.get().setFirstName("firstName");
		aTrainee.get().setLastName("lastName");
		aTrainee.get().setTraineeId(111l);
		traineeList1.add(aTrainee.get());
		
		bTrainee = Optional.of(traineeList);

		bTrainee.get().setFirstName("sceondName");
		bTrainee.get().setLastName("penultimateName");
		bTrainee.get().setTraineeId(111l);
		traineeList1.add(bTrainee.get());
		System.out.println(traineeList1);

		Mockito.when(traineeRepo.findAll()).thenReturn((List<Trainee>) traineeList1);
		

		Assert.assertEquals(service.getAll(), traineeList1);
		
	}
	
	
	
	
	

}
