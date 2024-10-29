package net.ayoub.billinginvoiceservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequestDTO {
    private double amount;
    private String customerId;
}
