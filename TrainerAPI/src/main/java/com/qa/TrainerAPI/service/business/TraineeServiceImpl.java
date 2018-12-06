package com.qa.TrainerAPI.service.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.TrainerAPI.persistence.domain.Trainee;
import com.qa.TrainerAPI.persistence.repository.TrainerRepository;

@Service
public class TraineeServiceImpl implements TraineeService{

	@Autowired
	private TrainerRepository trainerRepo;
	
//	@Autowired
//	private APICaller external;
	
	public void setRepo(TrainerRepository persist) {
		this.trainerRepo = persist;
	}
	
	
	
	@Override
	public Iterable<Trainee> getAll() {
		
		return null;
	}

	@Override
	public Optional<Trainee> get(Long traineeId) {
		return trainerRepo.findById(traineeId);
	}

	
	
}
