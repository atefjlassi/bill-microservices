package billing.service.web;

import billing.service.dto.InvoiceRequestDTO;
import billing.service.dto.InvoiceResponseDTO;
import billing.service.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestController {

    private InvoiceService invoiceService;

    @Autowired
    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(path = "/invoices/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String invoiceId) {
        return invoiceService.getInvoice(invoiceId);
    }

    @GetMapping(path = "/invoices/{customerId}/customers")
    public List<InvoiceResponseDTO> getInvoicesByCustomer(@PathVariable("customerId") String customerId) {
        return invoiceService.invoicesByCustomerId(customerId);
    }

    @PostMapping(path = "/invoices")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO) {
        return invoiceService.save(invoiceRequestDTO);
    }

    @GetMapping(path = "/invoices")
    public List<InvoiceResponseDTO> allInvoices() {
        return invoiceService.allInvoices();
    }
}
