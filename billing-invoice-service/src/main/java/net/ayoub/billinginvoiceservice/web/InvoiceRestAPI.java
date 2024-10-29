package net.ayoub.billinginvoiceservice.web;

import net.ayoub.billinginvoiceservice.dtos.InvoiceRequestDTO;
import net.ayoub.billinginvoiceservice.dtos.InvoiceResponseDTO;
import net.ayoub.billinginvoiceservice.services.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestAPI {
    private InvoiceService invoiceService;

    public InvoiceRestAPI(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(path = "/invoicesByCustomer/{customerId}")
    public List<InvoiceResponseDTO> getInvoiceByCustomerId(@PathVariable("customerId") String customerId) {
        return invoiceService.invoiceByCustomerId(customerId);
    }


    @PostMapping(path = "/invoices")
    public InvoiceResponseDTO saveInvoice(@RequestBody InvoiceRequestDTO invoiceRequestDTO){
        return invoiceService.saveInvoice(invoiceRequestDTO);
    }

    @GetMapping(path = "/invoices/{invoiceId}")
    public InvoiceResponseDTO getInvoice(@PathVariable String invoiceId){
        return invoiceService.getInvoice(invoiceId);
    }
}
