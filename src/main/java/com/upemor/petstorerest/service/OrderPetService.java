package com.upemor.petstorerest.service;

import java.util.List;

import com.upemor.petstorerest.model.Orderpet;

public interface OrderPetService {
	List<Orderpet> listAllOrderPets();
	
	Orderpet findById(int id);
	
	void createOrderPet(Orderpet orderPet);
	
	Orderpet updateOrderPet(int id,Orderpet orderPet);
	
	void deleteCategory(int id);
}
