package com.qa.TrainerAPI.service.business;

import java.util.Optional;

import com.qa.TrainerAPI.persistence.domain.Trainer;


public interface TrainerService {

	Iterable<Trainer> getAll();

	Optional<Trainer> get(Long trainerId);
	
	Trainer add(Trainer trainer);
	
	void delete(Long trainerId);
	
	String update (Long trainerId, Trainer updatedTrainer);
	
	


}
