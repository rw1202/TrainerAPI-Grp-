package com.qa.TrainerAPI.persistence.domain;

public class Trainee {

	private String firstName;
	private String lastName;
	private Long traineeId;
	
	public Trainee(String firstName, String lastName, long traineeId) {
		
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

}
