package com.qa.TrainerAPI.rest;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.TrainerAPI.persistence.domain.Trainee;
import com.qa.TrainerAPI.service.business.TraineeService;

@RequestMapping("/trainee")
@RestController
public class TrainerEndpoint {

	@Autowired
	private TraineeService service;

//		@GetMapping("${URL.method.processOffer}")
//		public Trainer send(@PathVariable String accountNumber) {
//			return service.prizeCheck(accountNumber);
//		}

//	@GetMapping("${URL.method.getAllTrainees}")
//	public Iterable<Trainee> getAllTrainees() {
//		return service.getAll();
//	}
	
	public TrainerEndpoint(TraineeService service) {
		this.service= service;
	}

	@GetMapping("/getTrainee")
	public Optional<Trainee> getTrainee(@PathVariable Long traineeId) {
		return service.get(traineeId);
	}

}
