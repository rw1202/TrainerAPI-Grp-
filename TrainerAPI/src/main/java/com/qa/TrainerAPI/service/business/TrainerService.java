package com.qa.TrainerAPI.service.business;



import com.qa.TrainerAPI.persistence.domain.Trainee;

public interface TrainerService {

	Iterable<Trainee> getAll();

	Trainee get(Long Id);

}
