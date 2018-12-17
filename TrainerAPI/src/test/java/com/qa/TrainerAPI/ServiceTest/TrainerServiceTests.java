package com.qa.TrainerAPI.ServiceTest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jms.core.JmsTemplate;

import com.qa.TrainerAPI.service.business.TrainerServiceImpl;
import com.qa.TrainerAPI.util.TrainerProducer;
import com.qa.persistence.domain.Trainer;
import com.qa.persistence.domain.User;
import com.qa.persistence.domain.UserRequest;
import com.qa.persistence.domain.UserRequest.requestType;


@RunWith(MockitoJUnitRunner.class)
public class TrainerServiceTests {
	
	@InjectMocks
	private TrainerServiceImpl service;
	
	@Mock
	private TrainerProducer producer;
	
	@Mock
	private JmsTemplate jmsTemplate;
	
	
	
	
	@Test
	public void testDelete() {
		UserRequest thisRequest = new UserRequest();
		User dummyUser = new Trainer("rob@mail.com");
		thisRequest.setHowToAct(requestType.DELETE);
		thisRequest.setUserToAddOrUpdate(dummyUser);

		Assert.assertEquals("Request placed on queue succesfully", service.delete(dummyUser.getUsername()));
	}
	
	@Test
	public void testUpdate() {
		UserRequest thisRequest = new UserRequest();
		Trainer updatedTrainer = new Trainer("rob@mail.com");
		Trainer dummyUser = new Trainer("rob@mail.com");
		dummyUser = updatedTrainer;
		dummyUser.setUsername(updatedTrainer.getUsername());
		thisRequest.setHowToAct(requestType.UPDATE);
		thisRequest.setUserToAddOrUpdate(dummyUser);

		Assert.assertEquals("Request placed on queue succesfully", service.update(dummyUser.getUsername(), updatedTrainer));
	}
	
	
}