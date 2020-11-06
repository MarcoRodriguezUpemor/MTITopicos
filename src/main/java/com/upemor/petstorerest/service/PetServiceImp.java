package com.upemor.petstorerest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upemor.petstorerest.model.Pet;
import com.upemor.petstorerest.repository.PetRepository;

@Service
public class PetServiceImp implements PetService{

	@Autowired
	PetRepository petRepository;
	
	@Override
	public List<Pet> listAllPets() {
		List<Pet> pets = petRepository.findAll();
		return pets;
	}

	@Override
	public Pet findById(int id) {
		Pet pet = petRepository.findById(id);
		return pet;
	}

	@Override
	public void createPet(Pet pet) {
		petRepository.save(pet);
	}

	@Override
	public Pet updatePet(int id, Pet pet) {
		Pet current = petRepository.findById(id);
		current.setName(pet.getName());
		current.setPhotourl(pet.getPhotourl());
		current.setPrice(pet.getPrice());
		current.setStatus(pet.isStatus());
		petRepository.save(current);
		return current;
	}

	@Override
	public void deletePet(int id) {
		petRepository.deleteById(id);
	}

}
