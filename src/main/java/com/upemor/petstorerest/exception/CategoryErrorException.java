package com.upemor.petstorerest.exception;

import com.upemor.petstorerest.model.Category;

public class CategoryErrorException extends Category{

	private String errorMsg;
	
	public CategoryErrorException(final String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public String getErsrorMsg() {
		return errorMsg;
	}
}
