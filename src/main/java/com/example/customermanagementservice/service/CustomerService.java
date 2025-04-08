package com.example.customermanagementservice.service;

import com.example.customermanagementservice.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
	// Create a new customer
	CustomerDTO createCustomer(CustomerDTO customerDTO);

	// Fetch a customer by their ID
	CustomerDTO getCustomerById(Long id);

	// Get a list of all customers
	List<CustomerDTO> getAllCustomers();

	// Update an existing customer using the ID
	CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);

	// Delete a customer by ID
	void deleteCustomer(Long id);
}
