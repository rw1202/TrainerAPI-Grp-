package com.qa.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.qa.TrainerAPI.persistence.domain.Trainer;

public class TrainerTest {

	@Test
	public void setAndGetTest(){
	Trainer trainer = new Trainer();	
	
	trainer.setFirstName("firstName");
	trainer.setLastName("lastName");
	trainer.setTrainerId(1L);
	
	assertEquals(trainer.getFirstName(), "firstName");
	assertEquals(trainer.getLastName(), "lastName");
	Assert.assertEquals(trainer.getTrainerId(), Long.valueOf(1L));
		
		
	}
	
	@Test
	public void toStringTest() {
		Trainer trainer= new Trainer();
		
		trainer.setFirstName("firstName");
		trainer.setLastName("lastName");
		trainer.setTrainerId(2L);
		
		assertEquals(trainer.toString(), "Trainer [firstName=firstName, lastName=lastName, trainerId=2]");
	
	} 
		
		
	}
	

