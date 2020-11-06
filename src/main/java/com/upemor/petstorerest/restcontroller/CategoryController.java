package com.upemor.petstorerest.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upemor.petstorerest.exception.CategoryErrorException;
import com.upemor.petstorerest.model.Category;
import com.upemor.petstorerest.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/")
	public ResponseEntity<List<Category>> listAllCategorys(){
		List<Category> categorys = categoryService.listAllCategorys();
		return new ResponseEntity<List<Category>>(categorys,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable("id") final int id){
		Category category = categoryService.findById(id);
		if (category == null) {
			return new ResponseEntity<Category>(
					new CategoryErrorException("Category with id "
					+ id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> createTag(@RequestBody final Category category) {
		categoryService.createCategory(category);		
		return new ResponseEntity<Category>(category, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> updateCategory(@PathVariable("id") final int id, @RequestBody Category category) {
		Category currentCat = categoryService.findById(id);
		if (currentCat == null) {
			return new ResponseEntity<Category>(
					new CategoryErrorException("Unable to upate. Category with id "
					+ id + " not found."), HttpStatus.NOT_FOUND);
		}
		Category updated = categoryService.updateCategory(id, category);
		return new ResponseEntity<Category>(updated, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Category> deleteCategory(@PathVariable("id") final int id) {
		Category current = categoryService.findById(id);
		if (current == null) {
			return new ResponseEntity<Category>(
					new CategoryErrorException("Unable to delete Catgory with id "
					+ id + " not found."), HttpStatus.NOT_FOUND);
		}
		categoryService.deleteCategory(id);
		return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
	}
	

}
