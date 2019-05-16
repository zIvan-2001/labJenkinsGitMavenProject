package com.tecsup.petclinic.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

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
	
	@Test
	public void testUpdatePet() {

		String PET_NAME = "Bear";
		int OWNER_ID = 1;
		int TYPE_ID = 1;
		long create_id = -1;

		String UP_PET_NAME = "Bear2";
		int UP_OWNER_ID = 2;
		int UP_TYPE_ID = 2;

		Pet pet = new Pet(PET_NAME, OWNER_ID, TYPE_ID);

		// Create record
		logger.info(">" + pet);
		Pet vpet = petService.create(pet);
		logger.info(">>" + pet);

		create_id = pet.getId();

		// Prepare data for update
		vpet.setName(UP_PET_NAME);
		vpet.setOwner_id(UP_OWNER_ID);
		vpet.setType_id(UP_TYPE_ID);

		// Execute update
		pet = petService.update(pet);
		logger.info(">>>>" + pet);

		assertThat(pet.getId()).isNotNull();
		assertEquals(create_id, vpet.getId());
		assertEquals(UP_PET_NAME, vpet.getName());
		assertEquals(UP_OWNER_ID, vpet.getType_id());
		assertEquals(UP_TYPE_ID, vpet.getOwner_id());
 
	}
}
