package com.upemor.petstorerest.exception;

import com.upemor.petstorerest.model.Orderpet;

public class OrderErrorException extends Orderpet {

	private String errorMsg;

	public OrderErrorException(final String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErsrorMsg() {
		return errorMsg;
	}
}
