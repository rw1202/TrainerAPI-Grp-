package com.qa.TrainerAPI.service.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.TrainerAPI.persistence.domain.Trainee;
import com.qa.TrainerAPI.persistence.repository.TraineeRepository;

@Service
public class TraineeServiceImpl implements TraineeService {

	@Autowired
	private TraineeRepository traineeRepo;

//	@Autowired
//	private APICaller external;

	public void setRepo(TraineeRepository persist) {
		this.traineeRepo = persist;
	}

	@Override
	public Iterable<Trainee> getAll() {

		return null;
	}

	@Override
	public Optional<Trainee> get(Long traineeId) {
		return null;
	}

}
