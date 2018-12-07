package com.qa.TrainerAPI.persistence.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {
	
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String firstName;
	private String lastName;
	private Boolean flagged;
	
	
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
		return Id;
	}
	public void setTraineeId(Long Id) {
		this.Id = Id;
	}
		
	public Boolean getFlagged() {
		return flagged;
	}
	public void setFlagged(Boolean flagged) {
		this.flagged = flagged;
	}
	@Override
	public String toString() {
		return "Trainee [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", flagged=" + flagged
				+ "]";
	}
	
	
	
	
	

}
