package com.upemor.petstorerest.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upemor.petstorerest.exception.OrderErrorException;
import com.upemor.petstorerest.model.Orderpet;
import com.upemor.petstorerest.service.OrderPetService;


@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {

	@Autowired
	OrderPetService orderService;
	
	@GetMapping("/")
	public ResponseEntity<List<Orderpet>> listAllOrders(){
		List<Orderpet> orders = orderService.listAllOrderPets();
		return new ResponseEntity<List<Orderpet>>(orders,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Orderpet> findById(@PathVariable("id") final int id){
		Orderpet order = orderService.findById(id);
		if (order == null) {
			return new ResponseEntity<Orderpet>(
					new OrderErrorException("OrderPet with id "
					+ id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Orderpet>(order, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orderpet> createOrder(@RequestBody final Orderpet order) {
		orderService.createOrderPet(order);
		return new ResponseEntity<Orderpet>(order, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orderpet> updateOrder(@PathVariable("id") final int id, @RequestBody Orderpet order) {
		Orderpet current = orderService.findById(id);
		if (current == null) {
			return new ResponseEntity<Orderpet>(
					new OrderErrorException("Unable to upate. Orderpet with id "
					+ id + " not found."), HttpStatus.NOT_FOUND);
		}
		Orderpet updated = orderService.updateOrderPet(id, order);
		return new ResponseEntity<Orderpet>(updated, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Orderpet> deleteOrder(@PathVariable("id") final int id) {
		Orderpet current = orderService.findById(id);
		if (current == null) {
			return new ResponseEntity<Orderpet>(
					new OrderErrorException("Unable to delete Order with id "
					+ id + " not found."), HttpStatus.NOT_FOUND);
		}
		orderService.deleteCategory(id);
		return new ResponseEntity<Orderpet>(HttpStatus.NO_CONTENT);
	}

}
