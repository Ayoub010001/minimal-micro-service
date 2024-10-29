package net.ayoub.billinginvoiceservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    //Persistent
    @Id
    private String invoiceId;
    private Date invoiceDate;
    private double amount;
    private String customerId;
    //Not Persistent
    @Transient
    private Customer customer;
}
