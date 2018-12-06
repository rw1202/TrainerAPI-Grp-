package com.qa.TrainerAPI.persistence.domain;

import java.util.function.IntPredicate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Trainee {
	
	
@Id
@GeneratedValue
	private Long traineeId;
	private String firstName;
	private String lastName;
	
	
	public Trainee() {
		
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
	public Long getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(Long traineeId) {
		this.traineeId = traineeId;
	}
	@Override
	public String toString() {
		return "Trainee [firstName=" + firstName + ", lastName=" + lastName + ", traineeId=" + traineeId + "]";
	}
	
	
	

}
