package net.ayoub.billinginvoiceservice.dtos;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ayoub.billinginvoiceservice.entities.Customer;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceResponseDTO {
    private String invoiceId;
    private Date invoiceDate;
    private double amount;
    private Customer customer;
}
