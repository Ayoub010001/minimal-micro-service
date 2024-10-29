package net.ayoub.billinginvoiceservice.services;

import net.ayoub.billinginvoiceservice.dtos.InvoiceRequestDTO;
import net.ayoub.billinginvoiceservice.dtos.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO saveInvoice(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO getInvoice(String invoiceId);
    //InvoiceResponseDTO updateInvoice(InvoiceRequestDTO invoiceRequestDTO);
    //List<InvoiceResponseDTO> getAllInvoice();
    List<InvoiceResponseDTO> invoiceByCustomerId(String customerId);
}
