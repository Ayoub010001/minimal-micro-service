package net.ayoub.billinginvoiceservice.services;

import net.ayoub.billinginvoiceservice.dtos.InvoiceRequestDTO;
import net.ayoub.billinginvoiceservice.dtos.InvoiceResponseDTO;
import net.ayoub.billinginvoiceservice.entities.Customer;
import net.ayoub.billinginvoiceservice.entities.Invoice;
import net.ayoub.billinginvoiceservice.mappers.InvoiceMappers;
import net.ayoub.billinginvoiceservice.repositories.InvoiceRepositories;
import net.ayoub.billinginvoiceservice.restClient.CustomerRestClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService{

    private InvoiceMappers invoiceMappers;
    private InvoiceRepositories invoiceRepositories;
    private CustomerRestClient customerRestClient;

    public InvoiceServiceImpl(CustomerRestClient customerRestClient, InvoiceRepositories invoiceRepositories, InvoiceMappers invoiceMappers) {
        this.customerRestClient = customerRestClient;
        this.invoiceRepositories = invoiceRepositories;
        this.invoiceMappers = invoiceMappers;
    }

    @Override
    public InvoiceResponseDTO saveInvoice(InvoiceRequestDTO invoiceRequestDTO) {
        Customer customer = customerRestClient.getCustomer(invoiceRequestDTO.getCustomerId());
        Invoice invoice = invoiceMappers.InvoiceRequestDTOToInvoice(invoiceRequestDTO);
        if(customer != null) {
            invoice.setCustomer(customer);
        }
        invoice.setInvoiceId(UUID.randomUUID().toString());
        invoice.setInvoiceDate(new Date());
        /*Verification of Referential Integration Invoice/customer*/
        Invoice invoiceSaved = invoiceRepositories.save(invoice);
        return invoiceMappers.InvoiceToInvoiceResponseDTO(invoiceSaved);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceId) {
        Invoice invoice = invoiceRepositories.findById(invoiceId).get();
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
        if(customer == null){
            throw new RuntimeException("Customer not found");
        }
        invoice.setCustomer(customer);
        return invoiceMappers.InvoiceToInvoiceResponseDTO(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> invoiceByCustomerId(String customerId) {
        List<Invoice> invoices = invoiceRepositories.findByCustomerId(customerId);
        return invoices
                .stream().map(inv -> invoiceMappers.InvoiceToInvoiceResponseDTO(inv)).toList();
    }
}
