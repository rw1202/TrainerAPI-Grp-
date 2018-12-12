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
	trainer.setUsername("first@mail.com");
	
	assertEquals( "firstName", trainer.getFirstName());
	assertEquals( "lastName", trainer.getLastName());
	Assert.assertEquals( String.valueOf("first@mail.com"),trainer.getUsername());
		
		
	}
	
	@Test
	public void toStringTest() {
		Trainer trainer= new Trainer();
		
		trainer.setFirstName("firstName");
		trainer.setLastName("lastName");
		trainer.setUsername("first@mail.com");
		
		assertEquals( "User [firstName=firstName, lastName=lastName, username=first@mail.com]", trainer.toString());
	
	} 
		
		
	}
	

