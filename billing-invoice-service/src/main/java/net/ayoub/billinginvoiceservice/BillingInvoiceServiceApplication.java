package net.ayoub.billinginvoiceservice;

import net.ayoub.billinginvoiceservice.dtos.InvoiceRequestDTO;
import net.ayoub.billinginvoiceservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class BillingInvoiceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingInvoiceServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(InvoiceService invoiceService){
        return args -> {
            invoiceService.saveInvoice(new InvoiceRequestDTO(1334,"db64427a-2609-443b-955a-89d8d79c21f0"));
            invoiceService.saveInvoice(new InvoiceRequestDTO(8990,"a04cf679-2dc7-49a1-8401-7e1d5e8b8b71"));
            invoiceService.saveInvoice(new InvoiceRequestDTO(1200,"a04cf679-2dc7-49a1-8401-7e1d5e8b8b71"));
        };
    }

}
