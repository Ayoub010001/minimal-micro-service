package net.ayoub.customerservice.web;

import net.ayoub.customerservice.dtos.CustomerRequestDTO;
import net.ayoub.customerservice.dtos.CustomerResponseDTO;
import net.ayoub.customerservice.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestAPI {
    private CustomerService customerService;

    public CustomerRestAPI(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> allCustomers() {
        return customerService.getAllCustomers();
    }
    @PostMapping(path = "/customers")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO) {
        return customerService.save(customerRequestDTO);
    }

    @GetMapping("/customers/{customerId}")
    public CustomerResponseDTO getCustomer(@PathVariable String customerId) {
        return customerService.getCustomer(customerId);
    }

}
