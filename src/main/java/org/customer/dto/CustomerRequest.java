package org.customer.dto;

import org.springframework.stereotype.Component;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
public class CustomerRequest {
	
	@NotNull(message = "First Name is mandatory")
	@NotBlank(message = "First Name should not be blank")
	private String firstName;
	
	@NotNull(message = "Last Name is mandatory")
	@NotBlank(message = "Last Name should not be blank")
	private String lastName;
	
	private String middleName;
	private String dateOfBirth;
	private String addressLine1;
	private String addressLine2;
	private String zip;
	private String city;
	private String state;
	private String country;
	
	@Size(min = 10, max = 12, message = "Number should have at minimum 10 and maximum 12 digits")
	private String mobilePhone;	
	
	@Size(min = 10, max = 12, message = "Number should have at minimum 10 and maximum 12 digits")
	private String homePhone;
	
	@Size(min = 10, max = 12, message = "Number should have at minimum 10 and maximum 12 digits")
	private String workPhone;
	
	@NotNull(message = "EmailID is mandatory")
	@NotBlank(message = "EmailID should not be blank")
	@Pattern(regexp = "[a-z0-9]{3,50}(@)[a-z]{3,50}(.)[a-z]{2,3}", message = "Invalid email format")
	private String emailID;
	
	private long customerId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastNaame) {
		this.lastName = lastNaame;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

}
