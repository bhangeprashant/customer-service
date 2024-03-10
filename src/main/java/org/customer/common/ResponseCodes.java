package org.customer.common;

public enum ResponseCodes {

	ADD_CUSTOMER_SUCCESS("Success", "Customer added successfully"), 
	ADD_CUSTOMER_DUPLICATE_EMAIL("FAIL", "Customer email already exists. Please enter valid Email ID"),
	CUSTOMER_NOT_FOUND("FAIL", "Customer not found");

	private final String code;
	private final String message;

	ResponseCodes(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
