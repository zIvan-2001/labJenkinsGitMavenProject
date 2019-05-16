package com.tecsup.petclinic.service;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
 
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tecsup.petclinic.domain.Pet;
import com.tecsup.petclinic.domain.PetRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PetService2Test {

	
	private static final Logger logger = LoggerFactory.getLogger(PetService2Test.class);

	
	@Autowired
	private PetService petService;
	
	@Test
	public void testFindById() {		
		// Sly		
		long id = 13;
		Pet p = petService.findById(id);
		Assert.assertEquals("Sly", p.getName());
	}
	
	@Test
	public void testFindByName() {
		
		String NAME = "Iggy";
		int SIZE_EXPECTED = 1;
		
		List<Pet> pets = petService.findByName(NAME);
		
		pets.stream().forEach(pet ->logger.info(">>>>>>>" +pet.getId()));
		
		Assert.assertEquals(SIZE_EXPECTED, pets.size());
		
	}
	
	/**
	 *  To get ID generate , you need 
	 *  setup in id primary key in your
	 *  entity this annotation :
	 *  	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 */
	@Test
	public void testCreatePet() {
		
		Pet newPet = new Pet("Kabul",1,1);
		
		Pet genPet = petService.create(newPet);
		
		logger.info(genPet.toString());

	}
}
