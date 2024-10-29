package net.ayoub.billinginvoiceservice.repositories;

import net.ayoub.billinginvoiceservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepositories extends JpaRepository<Invoice, String> {
    List<Invoice> findByCustomerId(String customerId);
}
