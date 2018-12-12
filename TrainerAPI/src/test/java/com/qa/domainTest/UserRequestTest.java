package com.qa.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.TrainerAPI.persistence.domain.Trainer;
import com.qa.TrainerAPI.persistence.domain.UserRequest;
import com.qa.TrainerAPI.persistence.domain.UserRequest.requestType;

public class UserRequestTest {
	private Trainer trainer;
	

	private UserRequest userRequest;
	
	@Test
	public void getHowToActTest() {
		userRequest = new UserRequest();
		userRequest.setHowToAct(requestType.READ);
		assertEquals(requestType.READ, userRequest.getHowToAct() );
	}
	
	@Test
	public void getUserToAddUpdateTest() {
		userRequest = new UserRequest();
		Trainer trainer = new Trainer();
		
		userRequest.setUserToAddOrUpdate(trainer);
		assertEquals(trainer, userRequest.getUserToAddOrUpdate());
	}
	
}
