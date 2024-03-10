package org.customer.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class DiscountRequest {

	@Min(value = 0, message = "Age must be greater than or equal to 0")
	private int age;

	@NotBlank(message = "Gender should not be blank")
	private String gender;


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
