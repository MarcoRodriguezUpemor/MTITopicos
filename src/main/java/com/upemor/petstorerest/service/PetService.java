package com.upemor.petstorerest.service;

import java.util.List;

import com.upemor.petstorerest.model.Pet;


public interface PetService {
	List<Pet> listAllPets();
	
	Pet findById(int id);
	
	void createPet(Pet pet);
	
	Pet updatePet(int id,Pet pet);
	
	void deletePet(int id);
}
