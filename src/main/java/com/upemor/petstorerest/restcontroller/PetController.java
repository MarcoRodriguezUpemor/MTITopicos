package com.upemor.petstorerest.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//simport org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upemor.petstorerest.exception.PetErrorException;
import com.upemor.petstorerest.model.Pet;
import com.upemor.petstorerest.service.PetService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/pet")
public class PetController {

	@Autowired
	PetService petService;
	
	@GetMapping("/")
	public ResponseEntity<List<Pet>> listAllPets(){
		List<Pet> pets = petService.listAllPets();
		return new ResponseEntity<List<Pet>>(pets, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pet> findById(@PathVariable("id") final int id){
		Pet pet= petService.findById(id);
		if (pet == null) {
			return new ResponseEntity<Pet>(
					new PetErrorException("Pet with id "
					+ id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pet>(pet, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pet> createPet(@RequestBody final Pet pet) {
		petService.createPet(pet);		
		return new ResponseEntity<Pet>(pet, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pet> updatePet(@PathVariable("id") final int id, @RequestBody Pet pet) {
		Pet current = petService.findById(id);
		if (current == null) {
			return new ResponseEntity<Pet>(
					new PetErrorException("Unable to upate. Pet with id "
					+ id + " not found."), HttpStatus.NOT_FOUND);
		}
		Pet updated = petService.updatePet(id, pet);
		return new ResponseEntity<Pet>(updated, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Pet> deletePet(@PathVariable("id") final int id) {
		Pet current = petService.findById(id);
		if (current == null) {
			return new ResponseEntity<Pet>(
					new PetErrorException("Unable to delete Catgory with id "
					+ id + " not found."), HttpStatus.NOT_FOUND);
		}
		petService.deletePet(id);
		return new ResponseEntity<Pet>(HttpStatus.NO_CONTENT);
	}
	

}
