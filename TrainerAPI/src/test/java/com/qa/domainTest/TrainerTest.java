package com.qa.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.qa.persistence.domain.Trainer;

public class TrainerTest {

	@Test
	public void setAndGetTest(){
	Trainer trainer = new Trainer();	
	
	trainer.setFirstName("firstName");
	trainer.setLastName("lastName");
	trainer.setPassword("password");
	trainer.setType("trainer");
	trainer.setUsername("rob@mail.com");
	
	assertEquals( "firstName", trainer.getFirstName());
	assertEquals( "lastName", trainer.getLastName());
	assertEquals("password", trainer.getPassword());
	assertEquals("trainer", trainer.getType());
	
	Assert.assertEquals("rob@mail.com",trainer.getUsername());
		
		
	}
	
	@Test
	public void toStringTest() {
		Trainer trainer= new Trainer();
		
		trainer.setFirstName("firstName");
		trainer.setLastName("lastName");
		trainer.setPassword("password");
		trainer.setType("trainer");
		trainer.setUsername("rob@mail.com");
		assertEquals( "User [firstName=firstName, lastName=lastName, _id=rob@mail.com, password=password, type=trainer]", trainer.toString());
	
	} 
		
		
	}
	

