package org.customer.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.customer.common.ResponseCodes;
import org.customer.dto.CustomerRequest;
import org.customer.dto.CustomerResponse;
import org.customer.dto.DiscountRequest;
import org.customer.dto.DiscountResponse;
import org.customer.dto.SearchCustomerResponse;
import org.customer.entity.Customer;
import org.customer.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	CustomerResponse customerResponse;

	@Autowired
	SearchCustomerResponse searchCustomerResponse;

	@Autowired
	DiscountResponse discountResponse;

	@Override
	public CustomerResponse addCustomerDetails(CustomerRequest customerRequest) {

		if (customerRepo.existsByEmail_id(customerRequest.getEmailID())) {
			customerResponse.setStatus(ResponseCodes.ADD_CUSTOMER_DUPLICATE_EMAIL.getCode());
			customerResponse.setMessage(ResponseCodes.ADD_CUSTOMER_DUPLICATE_EMAIL.getMessage());
			customerResponse.setCustomerCode(0000);
		} else {

			Customer customerTable = Customer.getInstance().setFirst_name(customerRequest.getFirstName())
					.setMiddle_name(customerRequest.getMiddleName())
					.setLast_name(customerRequest.getLastName())
					.setDate_of_birth(customerRequest.getDateOfBirth())
					.setAddress_line1(customerRequest.getAddressLine1())
					.setAddress_line2(customerRequest.getAddressLine2())
					.setZip(customerRequest.getZip())
					.setCity(customerRequest.getCity())
					.setState(customerRequest.getState())
					.setCountry(customerRequest.getCountry())
					.setMobile_phone(customerRequest.getMobilePhone())
					.setHome_phone(customerRequest.getHomePhone())
					.setWork_phone(customerRequest.getWorkPhone())
					.setEmail_id(customerRequest.getEmailID())
					.setCustomer_id(customerRequest.getCustomerId())
					.setCreated_date(LocalDateTime.now())
					.setUpdated_date(LocalDateTime.now());

			try {
				customerTable = customerRepo.save(customerTable);
			} catch (Exception e) {
				e.printStackTrace();
			}

			customerResponse.setStatus(ResponseCodes.ADD_CUSTOMER_SUCCESS.getCode());
			customerResponse.setMessage(ResponseCodes.ADD_CUSTOMER_SUCCESS.getMessage());
			customerResponse.setCustomerCode(customerTable.getCustomer_code());

		}
		return customerResponse;
	}

	public CustomerResponse updateCustomerDetails(long id, CustomerRequest customerRequest) {

		Optional<Customer> customerTable = customerRepo.findById(id);
		if (customerTable.isEmpty()) {
			customerResponse.setStatus(ResponseCodes.CUSTOMER_NOT_FOUND.getCode());
			customerResponse.setMessage(ResponseCodes.CUSTOMER_NOT_FOUND.getMessage());
			customerResponse.setCustomerCode(0000);
		} else {
			Customer customer = Customer.getInstance().setFirst_name(customerRequest.getFirstName())
					.setMiddle_name(customerRequest.getMiddleName()).setLast_name(customerRequest.getLastName())
					.setDate_of_birth(customerRequest.getDateOfBirth())
					.setAddress_line1(customerRequest.getAddressLine1())
					.setAddress_line2(customerRequest.getAddressLine2()).setZip(customerRequest.getZip())
					.setCity(customerRequest.getCity()).setState(customerRequest.getState())
					.setCountry(customerRequest.getCountry()).setMobile_phone(customerRequest.getMobilePhone())
					.setHome_phone(customerRequest.getHomePhone()).setWork_phone(customerRequest.getWorkPhone())
					.setEmail_id(customerRequest.getEmailID()).setCustomer_id(customerRequest.getCustomerId())
					.setCreated_date(LocalDateTime.now()).setUpdated_date(LocalDateTime.now());

		}

		return customerResponse;

	}

	public CustomerResponse findByMobileNumber(String mobile_number) {

		List<Customer> customerTable = customerRepo.findByMobile(mobile_number);
		if (customerTable.isEmpty()) {
			customerResponse.setStatus(ResponseCodes.CUSTOMER_NOT_FOUND.getCode());
			customerResponse.setMessage(ResponseCodes.CUSTOMER_NOT_FOUND.getMessage());
			customerResponse.setCustomerCode(0000);
		} else {
			Customer receivedData = customerTable.get(0);

			searchCustomerResponse.setStatus("Success");
			searchCustomerResponse.setMessage("Customer ddetails are as follows :");
			searchCustomerResponse.setCustomerCode(receivedData.getCustomer_code());
			searchCustomerResponse.getCustomerData().setFirstName(receivedData.getFirst_name());
			searchCustomerResponse.getCustomerData().setMiddleName(receivedData.getMiddle_name());
			searchCustomerResponse.getCustomerData().setMiddleName(receivedData.getLast_name());
			searchCustomerResponse.getCustomerData().setDateOfBirth(receivedData.getDate_of_birth());
			searchCustomerResponse.getCustomerData().setAddressLine1(receivedData.getAddress_line1());
			searchCustomerResponse.getCustomerData().setAddressLine2(receivedData.getAddress_line2());
			searchCustomerResponse.getCustomerData().setZip(receivedData.getZip());
			searchCustomerResponse.getCustomerData().setCity(receivedData.getCity());
			searchCustomerResponse.getCustomerData().setState(receivedData.getState());
			searchCustomerResponse.getCustomerData().setCountry(receivedData.getCountry());
			searchCustomerResponse.getCustomerData().setMobilePhone(receivedData.getMobile_phone());
			searchCustomerResponse.getCustomerData().setHomePhone(receivedData.getHome_phone());
			searchCustomerResponse.getCustomerData().setWorkPhone(receivedData.getWork_phone());
			searchCustomerResponse.getCustomerData().setEmailID(receivedData.getEmail_id());

		}

		return customerResponse;
	}

	public DiscountResponse getDiscount(DiscountRequest request) {

		int age = request.getAge();
		String gender = request.getGender();
		int discount = 0;

		if (age < 30) {
			discount += 10;
		} else if (age >= 30 && age < 60) {
			discount += 5;
		} else if (age >= 60) {
			discount += 15;
		}

		if (gender.equalsIgnoreCase("F")) {
			discount += 5;
		}

		discountResponse.setDiscount(discount);
		return discountResponse;
	}

}
