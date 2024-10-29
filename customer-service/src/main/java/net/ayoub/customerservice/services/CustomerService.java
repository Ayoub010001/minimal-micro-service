package net.ayoub.customerservice.services;

import net.ayoub.customerservice.dtos.CustomerRequestDTO;
import net.ayoub.customerservice.dtos.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO CustomerRequestDTO);
    CustomerResponseDTO getCustomer(String CustomerId);
    CustomerResponseDTO updateCustomer(CustomerRequestDTO CustomerRequestDTO);
    List<CustomerResponseDTO> getAllCustomers();
}
