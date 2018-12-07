package com.qa.TrainerAPI.service.business;





import java.util.Optional;

import com.qa.TrainerAPI.persistence.domain.Trainee;


public interface TraineeService {

	Iterable<Trainee> getAll();

	Optional<Trainee> get(Long traineeId);

}
