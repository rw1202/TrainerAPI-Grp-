package com.qa.TrainerAPI.service.business;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.TrainerAPI.persistence.domain.Trainee;
import com.qa.TrainerAPI.persistence.repository.TrainerRepository;

@Service
public class TraineeServiceImpl implements TraineeService {

	@Autowired
	private TrainerRepository traineeRepo;

//	@Autowired
//	private APICaller external;

	public void setRepo(TrainerRepository traineeRepo) {
		this.traineeRepo = traineeRepo;
	}

	@Override
	public Iterable<Trainee> getAll() {

		return traineeRepo.findAll();
	}

	@Override
	public Optional<Trainee> get(Long traineeId) {
		return traineeRepo.findById(traineeId);
	}

}
