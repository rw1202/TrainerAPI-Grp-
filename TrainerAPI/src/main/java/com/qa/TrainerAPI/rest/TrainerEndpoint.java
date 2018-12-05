package com.qa.TrainerAPI.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.qa.TrainerAPI.persistence.domain.Trainee;
import com.qa.TrainerAPI.service.business.TrainerService;

public class TrainerEndpoint {
	
	

	@RequestMapping("${URL.base}")
	@RestController
	public class AccountEndpoint {

		@Autowired
		private TrainerService service;

//		@GetMapping("${URL.method.processOffer}")
//		public Trainer send(@PathVariable String accountNumber) {
//			return service.prizeCheck(accountNumber);
//		}

		@GetMapping("${URL.method.getAllTrainees}")
		public Iterable<Trainee> getAllTrainees() {
			return service.getAll();
		}

		@GetMapping("${URL.method.getTrainee}")
		public Trainee getTrainee(@PathVariable Long Id) {
			return service.get(Id);
		}

	
	}
	
		
	}

	
	

