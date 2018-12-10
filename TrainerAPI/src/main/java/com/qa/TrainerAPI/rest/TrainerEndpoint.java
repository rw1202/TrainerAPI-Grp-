package com.qa.TrainerAPI.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qa.TrainerAPI.persistence.domain.Trainer;
import com.qa.TrainerAPI.service.business.TrainerService;

@RequestMapping("/trainer")
@RestController
public class TrainerEndpoint {

	@Autowired
	private TrainerService service;

	public TrainerEndpoint(TrainerService service) {
		this.service = service;
	}

	public TrainerEndpoint() {
	}

	@GetMapping("${URL.method.getTrainer}/{Id}")
	public Optional<Trainer> getTrainer(@PathVariable Long Id) {
		return service.get(Id);
	}

	@GetMapping("${URL.method.getAllTrainers}")
	public Iterable<Trainer> getAllTrainers() {
		return service.getAll();
	}

	@DeleteMapping("${URL.method.deleteTrainer}/{Id}")
	public void deleteTrainer(@PathVariable Long Id) {
		service.delete(Id);
	}

	@PostMapping("${URL.method.addTrainer}")
	public Trainer addTrainer(@RequestBody Trainer trainer) {
		return service.add(trainer);
	}

	@PutMapping("${URL.method.updateTrainer}")
	public Trainer updateTrainer(@RequestBody Trainer trainer) {
		return service.add(trainer);
	}
}
