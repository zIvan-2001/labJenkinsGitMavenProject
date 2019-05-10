package com.tecsup.petclinic.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author jgomezm
 *
 */
@Entity(name = "pets")
public class Pet {

	@Id
	private long id;
	private String name;
	private int type_id, owner_id;

	public Pet() {
	}

	public Pet(long id, String name, int type_id, int owner_id) {
		super();
		this.id = id;
		this.name = name;
		this.type_id = type_id;
		this.owner_id = owner_id;
	}

	public Pet(String name, int type_id, int owner_id) {
		super();
		this.name = name;
		this.type_id = type_id;
		this.owner_id = owner_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", type_id=" + type_id + ", owner_id=" + owner_id + "]";
	}

	
	
}
