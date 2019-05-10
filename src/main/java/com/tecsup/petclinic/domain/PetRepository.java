package com.tecsup.petclinic.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author jgomezm
 *
 */
@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

	// Fetch cars by name
	List<Pet> findByName(String name);

	// Fetch cars by owner_id
	//List<Pet> findByType_id(String owner_id);

	// Fetch cars by owner_id
	//List<Pet> findByOwner_id(int owner_id);

}
