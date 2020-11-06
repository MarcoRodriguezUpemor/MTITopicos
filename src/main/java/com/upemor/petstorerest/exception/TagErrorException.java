package com.upemor.petstorerest.exception;

import com.upemor.petstorerest.model.Tag;

public class TagErrorException extends Tag {

	private String errorMsg;
	
	public TagErrorException(final String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public String getErsrorMsg() {
		return errorMsg;
	}
}
