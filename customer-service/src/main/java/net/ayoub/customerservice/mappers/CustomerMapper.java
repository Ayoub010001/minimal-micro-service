package net.ayoub.customerservice.mappers;

import net.ayoub.customerservice.dtos.CustomerRequestDTO;
import net.ayoub.customerservice.dtos.CustomerResponseDTO;
import net.ayoub.customerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO CustomerToCustomerResponseDTO(Customer customer);
    Customer CustomerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
}
