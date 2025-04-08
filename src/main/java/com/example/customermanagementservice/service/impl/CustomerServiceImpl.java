package com.example.customermanagementservice.service.impl;

import com.example.customermanagementservice.dto.CustomerDTO;


import com.example.customermanagementservice.entity.Customer;
import com.example.customermanagementservice.repository.CustomerRepository;
import com.example.customermanagementservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO createCustomer(CustomerDTO dto) {
        Customer customer = new Customer(dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getPhone());
        customer = customerRepository.save(customer);
        dto.setId(customer.getId());
        return dto;
    }
    
    @Override
    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
        return mapToDTO(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO dto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));

        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());

        customerRepository.save(customer);
        return mapToDTO(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    private CustomerDTO mapToDTO(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhone()
        );
    }
    
}
