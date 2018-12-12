package com.qa.TrainerAPI.service.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.qa.TrainerAPI.persistence.domain.Trainer;
import com.qa.TrainerAPI.persistence.domain.User;
import com.qa.TrainerAPI.persistence.domain.UserRequest;
import com.qa.TrainerAPI.persistence.domain.UserRequest.requestType;
import com.qa.TrainerAPI.util.Constants;
import com.qa.TrainerAPI.util.TrainerProducer;

@Service
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	private TrainerProducer producer;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private RestTemplate apiCaller;

	public String add(Trainer trainer, String password) {
		producer.produce(trainer);

		return Constants.TRAINER_QUEUED_MESSAGE;
	}

	public Optional<Trainer> get(String userName) {
		UserRequest thisRequest = new UserRequest();
		User dummyUser = new Trainer();
		dummyUser.setUsername(userName);
		thisRequest.setHowToAct(requestType.READ);
		thisRequest.setUserToAddOrUpdate(dummyUser);
		producer.produce(thisRequest);
		return (Optional) jmsTemplate.receiveAndConvert(Constants.OUTGOING_TRAINER_QUEUE_NAME);
	}

	public Iterable<Trainer> getAll() {
		UserRequest thisRequest = new UserRequest();
		thisRequest.setHowToAct(requestType.READALL);
		producer.produce(thisRequest);
		return (Iterable<Trainer>) jmsTemplate.receiveAndConvert(Constants.OUTGOING_TRAINER_QUEUE_NAME);
	}

	public String delete(String userName) {
		UserRequest thisRequest = new UserRequest();
		User dummyUser = new Trainer();
		dummyUser.setUsername(userName);
		thisRequest.setHowToAct(requestType.DELETE);
		thisRequest.setUserToAddOrUpdate(dummyUser);
		producer.produce(thisRequest);
		return Constants.REQUEST_QUEUED_MESSAGE;

	}

	public String update(String userName, Trainer updatedTrainer) {
		UserRequest thisRequest = new UserRequest();
		User dummyUser = updatedTrainer;
		dummyUser.setUsername(userName);
		thisRequest.setHowToAct(requestType.UPDATE);
		thisRequest.setUserToAddOrUpdate(dummyUser);
		producer.produce(thisRequest);
		return Constants.REQUEST_QUEUED_MESSAGE;
	}

}
