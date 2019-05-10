package com.tecsup.petclinic.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

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


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PetServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(PetServiceTest.class);

	
	@Autowired
	private PetService petService;

	/**
	 * 
	 */
	@Test
	public void testFindPetById() {

		Long ID = new Long(1);
		String NAME = "Leo";
		
		Pet pet = petService.findById(ID);
		logger.info(""+pet);
		
		Assert.assertEquals(NAME, pet.getName());

	}
	
	/**
	 * 
	 */
	@Test
	public void testFindPetByName() {
		
		String FIND_NAME = "Leo"; 
		int SIZE_EXPECTED = 1;
		
		List<Pet> pets = petService.findByName(FIND_NAME);
		
		Assert.assertEquals(SIZE_EXPECTED, pets.size());
	}

	
	/**
	 * 
	 */
	@Test
	public void testCreatePet() {
		
		String PET_NAME ="Ponky"; 
		int OWNER_ID = 1; 
		int TYPE_ID = 1; 
		
		Pet pet = new Pet(PET_NAME, 1, 1);
		pet = petService.create(pet);
		logger.info(""+pet);
		
		assertThat(pet.getId()).isNotNull();
		assertEquals(PET_NAME, pet.getName());
		assertEquals(OWNER_ID, pet.getOwner_id());
		assertEquals(TYPE_ID, pet.getType_id());
		
	}

}
