package net.ayoub.billinginvoiceservice.restClient;

import net.ayoub.billinginvoiceservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping(path = "/api/customers/{customerId}")
    Customer getCustomer(@PathVariable String customerId);

    @GetMapping(path="/api/customers")
    List<Customer> allCustomers();
}
