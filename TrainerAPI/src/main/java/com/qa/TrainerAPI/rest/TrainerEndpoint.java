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
	public Optional<Trainer> getTrainer(@PathVariable String username) {
		return service.get(username);
	}

	@GetMapping("${URL.method.getAllTrainers}")
	public Iterable<Trainer> getAllTrainers() {
		return service.getAll();
	}

	@DeleteMapping("${URL.method.deleteTrainer}/{Id}")
	public void deleteTrainer(@PathVariable String username) {
		service.delete(username);
	}

	@PostMapping("${URL.method.addTrainer}")
	public String addTrainer(@RequestBody Trainer trainer, String password) {
		return service.add(trainer, password);
	}

	@PutMapping("${URL.method.updateTrainer}")
	public String updateTrainer(@RequestBody Trainer trainer, String password) {
		return service.add(trainer, password);
	}
}
