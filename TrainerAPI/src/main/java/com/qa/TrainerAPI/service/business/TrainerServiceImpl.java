package com.qa.TrainerAPI.service.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.TrainerAPI.persistence.domain.Trainer;
import com.qa.TrainerAPI.persistence.repository.TrainerRepository;
import com.qa.TrainerAPI.util.Constants;

@Service
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	private TrainerRepository trainerRepo;

	public void setRepo(TrainerRepository trainerRepo) {
		this.trainerRepo = trainerRepo;
	}

	@Override
	public Iterable<Trainer> getAll() {

		return trainerRepo.findAll();
	}

	public Trainer add(Trainer trainer) {

		return trainerRepo.save(trainer);
	}

	@Override
	public void delete(Long trainerId) {
		trainerRepo.deleteById(trainerId);

	}

	public String update(Long trainerId, Trainer updatedTrainer) {
		if (trainerRepo.findById(trainerId).isPresent()) {
			Trainer oldTrainer = trainerRepo.findById(trainerId).get();
			oldTrainer.setFirstName(updatedTrainer.getFirstName());
			oldTrainer.setFirstName(updatedTrainer.getLastName());

			trainerRepo.save(oldTrainer);
			return Constants.TRAINER_UPD;
		}
		else {
			return Constants.INVALID_MESSAGE;
		}

	}

	@Override
	public Optional<Trainer> get(Long trainerId) {

		return trainerRepo.findById(trainerId);
	}

}
