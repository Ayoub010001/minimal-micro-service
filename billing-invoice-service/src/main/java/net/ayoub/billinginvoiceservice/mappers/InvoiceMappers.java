package net.ayoub.billinginvoiceservice.mappers;

import net.ayoub.billinginvoiceservice.dtos.InvoiceRequestDTO;
import net.ayoub.billinginvoiceservice.dtos.InvoiceResponseDTO;
import net.ayoub.billinginvoiceservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMappers {
    Invoice InvoiceRequestDTOToInvoice(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO InvoiceToInvoiceResponseDTO(Invoice invoice);
}
