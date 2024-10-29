package net.ayoub.billinginvoiceservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String customerId;
    private String fullName;
    private String email;
}
