package billing.service.services;

import billing.service.dto.InvoiceRequestDTO;
import billing.service.dto.InvoiceResponseDTO;
import billing.service.entities.Invoice;

import java.util.List;

public interface InvoiceService {
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO getInvoice(String invoiceId);
    List<InvoiceResponseDTO> invoicesByCustomerId(String customerId);

    List<InvoiceResponseDTO> allInvoices();
}
