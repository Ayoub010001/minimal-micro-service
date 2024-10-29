package net.ayoub.customerservice.services;

import lombok.AllArgsConstructor;
import net.ayoub.customerservice.dtos.CustomerRequestDTO;
import net.ayoub.customerservice.dtos.CustomerResponseDTO;
import net.ayoub.customerservice.entities.Customer;
import net.ayoub.customerservice.mappers.CustomerMapper;
import net.ayoub.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO CustomerRequestDTO) {
        /*Mapping Object - Object*/
        Customer customer = customerMapper.CustomerRequestDTOToCustomer(CustomerRequestDTO);
        customer.setCustomerId(UUID.randomUUID().toString());
        Customer savedCustomer = customerRepository.save(customer);
        /*Mapping Object - Object*/
        return customerMapper.CustomerToCustomerResponseDTO(savedCustomer);
    }

    @Override
    public CustomerResponseDTO getCustomer(String CustomerId) {
        Customer customer = customerRepository.findById(CustomerId).get();
        return customerMapper.CustomerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO updateCustomer(CustomerRequestDTO CustomerRequestDTO) {
        Customer customer = customerMapper.CustomerRequestDTOToCustomer(CustomerRequestDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.CustomerToCustomerResponseDTO(savedCustomer);
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOS = customers.stream()
                .map(c -> customerMapper.CustomerToCustomerResponseDTO(c)).toList();
        return customerResponseDTOS;
    }
}
