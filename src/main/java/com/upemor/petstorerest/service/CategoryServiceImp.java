package com.upemor.petstorerest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upemor.petstorerest.model.Category;
import com.upemor.petstorerest.repository.CategoryRepository;


@Service
public class CategoryServiceImp implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> listAllCategorys() {
		List<Category> categorys = categoryRepository.findAll();
		return categorys;
	}

	@Override
	public Category findById(int id) {
		Category category = categoryRepository.findById(id);
		return category;
	}

	@Override
	public void createCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(int id, Category category) {
		Category current = categoryRepository.findById(id);
		current.setName(category.getName());
		categoryRepository.save(current);
		return current;
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);
	}

}
