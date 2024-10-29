package net.ayoub.customerservice.dtos;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {
    private String customerId;
    private String fullName;
    private String email;
}
