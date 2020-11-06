package com.upemor.petstorerest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upemor.petstorerest.model.Orderpet;
import com.upemor.petstorerest.repository.OrderpetRepository;

@Service
public class OrderpetServiceImp implements OrderPetService{

	@Autowired
	OrderpetRepository orderRepository;
	
	@Override
	public List<Orderpet> listAllOrderPets() {
		List<Orderpet> orders = orderRepository.findAll();
		return orders;
	}

	@Override
	public Orderpet findById(int id) {
		Orderpet order = orderRepository.findById(id);
		return order;
	}

	@Override
	public void createOrderPet(Orderpet orderPet) {
		orderRepository.save(orderPet);
	}

	@Override
	public Orderpet updateOrderPet(int id, Orderpet orderPet) {
		Orderpet current = orderRepository.findById(id);
		current.setCreated(orderPet.getCreated());
		orderRepository.save(current);
		return current;
	}

	@Override
	public void deleteCategory(int id) {
		orderRepository.deleteById(id);
	}

}
