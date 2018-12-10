package com.qa.TrainerAPI.persistence.domain;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long trainerId;
	private String firstName;
	private String lastName;

	public Trainer() {
//Reflection
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}

	@Override
	public String toString() {
		return "Trainer [firstName=" + firstName + ", lastName=" + lastName + ", trainerId=" + trainerId + "]";
	}

}
