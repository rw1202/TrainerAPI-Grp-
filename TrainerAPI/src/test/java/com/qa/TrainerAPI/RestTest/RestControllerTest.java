package com.qa.TrainerAPI.RestTest;




import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

	private Iterable<Trainee> traineeList;
	private Optional<Trainee> trainee;
	private Trainee aTrainee;


	@MockBean
	TraineeService service;
	@Autowired
	private MockMvc mockMvc;


	@Before
	public void start() {

	
		Trainee traineeList = new Trainee();
		trainee = Optional.of(traineeList);

		
		
		

		trainee.get().setFirstName("firstName");
		trainee.get().setLastName("lastName");
		trainee.get().setTraineeId(111l);

	}

	@Test
	public void getTrainee_shouldReturnTrainee() {
		BDDMockito.given(service.get(111l)).willReturn(trainee);
		
		try {
			mockMvc.perform(MockMvcRequestBuilders.get(":8081/trainee/111l"))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("firstName").value("firstName"))
					.andExpect(MockMvcResultMatchers.jsonPath("lastName").value("lastName"));
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}



	
	@Test
	public void getAllTrainees_shouldReturnAllTrainees() {
		
		BDDMockito.given(service.getAll()).willReturn((Iterable<Trainee>) traineeList);
		try {
			mockMvc.perform(MockMvcRequestBuilders.get(":8081/trainee/111l"))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("firstName").value("firstName"))
					.andExpect(MockMvcResultMatchers.jsonPath("lastName").value("lastName"));
		} catch (Exception e) {
 			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	}