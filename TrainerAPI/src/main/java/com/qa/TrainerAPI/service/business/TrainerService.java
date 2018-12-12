package com.qa.TrainerAPI.service.business;

import java.util.Optional;

import com.qa.TrainerAPI.persistence.domain.Trainer;

public interface TrainerService {

	Iterable<Trainer> getAll();

	Optional<Trainer> get(String username);

	String add(Trainer trainer, String password);

	String delete(String username);

	String update(String username, Trainer updatedTrainer);

}
