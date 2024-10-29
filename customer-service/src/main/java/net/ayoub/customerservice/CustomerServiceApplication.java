package net.ayoub.customerservice;

import net.ayoub.customerservice.dtos.CustomerRequestDTO;
import net.ayoub.customerservice.entities.Customer;
import net.ayoub.customerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CustomerService customerService) {
        return args -> {
           customerService.save(new CustomerRequestDTO("C01","John", "Doe@doe.com"));
           customerService.save(new CustomerRequestDTO("C02","Adam", "Adam@adam.com"));
        };
    }

}
