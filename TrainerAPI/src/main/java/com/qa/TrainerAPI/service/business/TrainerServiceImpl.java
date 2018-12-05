package com.qa.TrainerAPI.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.TrainerAPI.persistence.domain.Trainee;
import com.qa.TrainerAPI.persistence.repository.TrainerRepository;

@Service
public class TrainerServiceImpl implements TrainerService{

	@Autowired
	private TrainerRepository trainerRepo;
	
//	@Autowired
//	private APICaller external;
	
	public void setRepo(TrainerRepository persist) {
		this.trainerRepo = persist;
	}
	
	
	
	@Override
	public Iterable<Trainee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trainee get(Long Id) {
		return trainerRepo.findbyId(Id);
	}

	
	
}
