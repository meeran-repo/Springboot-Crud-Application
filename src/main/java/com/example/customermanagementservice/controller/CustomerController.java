package com.example.customermanagementservice.controller;

import com.example.customermanagementservice.dto.CustomerDTO;
import com.example.customermanagementservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
		return ResponseEntity.ok(customerService.createCustomer(customerDTO));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
		return ResponseEntity.ok(customerService.getCustomerById(id));
	}

	@GetMapping
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
		return ResponseEntity.ok(customerService.getAllCustomers());
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
		return ResponseEntity.ok(customerService.updateCustomer(id, customerDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return ResponseEntity.ok("Customer deleted successfully.");
	}
}
