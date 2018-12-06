package com.qa.TrainerAPI.RestTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.TrainerAPI.persistence.domain.Trainee;
import com.qa.TrainerAPI.persistence.repository.TraineeRepository;
import com.qa.TrainerAPI.service.business.TraineeService;
import com.qa.TrainerAPI.service.business.TraineeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TrainerServiceTest {
	@InjectMocks
	TraineeServiceImpl service;
	
	private Optional<Trainee> aTrainee;
	private Optional<Trainee> bTrainee;
	@MockBean
	TraineeRepository traineeRepo;

	@Before
	public void set() throws Exception {

	}

	@Test
	public void getTrainee_returnsTrainee() {
		Trainee traineeList = new Trainee();

		aTrainee = Optional.of(traineeList);

		aTrainee.get().setFirstName("firstName");
		aTrainee.get().setLastName("LastName");
		aTrainee.get().setTraineeId(111l);
		

		BDDMockito.given(traineeRepo.findById(111l)).willReturn(aTrainee);

		assertThat(service.get(111l).get().getTraineeId()).isEqualTo(111l);

	}

}
