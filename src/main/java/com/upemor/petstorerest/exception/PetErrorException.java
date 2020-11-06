package com.upemor.petstorerest.exception;

import com.upemor.petstorerest.model.Pet;

public class PetErrorException extends Pet {

	private String errorMsg;

	public PetErrorException(final String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErsrorMsg() {
		return errorMsg;
	}
}
