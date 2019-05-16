package com.tecsup.petclinic.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.tecsup.petclinic.domain.Pet;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PetService2Test {

	@Autowired
	private PetService petService;
	

	@Test
	public void testFindById() {
		
		// Sly		
		long id = 13;
		Pet p = petService.findById(id);
		Assert.assertEquals("Sly", p.getName());
		
	}
}
