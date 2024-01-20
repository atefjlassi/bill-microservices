package billing.service.mappers;

import billing.service.dto.InvoiceRequestDTO;
import billing.service.dto.InvoiceResponseDTO;
import billing.service.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);
}
