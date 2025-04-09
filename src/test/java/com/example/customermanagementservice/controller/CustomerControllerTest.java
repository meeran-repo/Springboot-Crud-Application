package com.example.customermanagementservice.controller;

import com.example.customermanagementservice.dto.CustomerDTO;
import com.example.customermanagementservice.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerService customerService;

    @Test
    void testCreateCustomer_InvalidEmail_ShouldReturnBadRequest() throws Exception {
        CustomerDTO dto = new CustomerDTO();
        dto.setFirstName("Joe");
        dto.setLastName("Karl");
        dto.setEmail("invalid-email");
        dto.setPhone("1234567890");

        mockMvc.perform(post("/api/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testCreateCustomer_BlankFirstName_ShouldReturnBadRequest() throws Exception {
        CustomerDTO dto = new CustomerDTO();
        dto.setFirstName("");
        dto.setLastName("Karl");
        dto.setEmail("joe@example.com");
        dto.setPhone("1234567890");

        mockMvc.perform(post("/api/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }
}
