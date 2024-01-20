package billing.service.dto;

import billing.service.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
public class InvoiceResponseDTO {

    private String id;
    private LocalDate date;
    private BigDecimal amount;
    private Customer customer;
}
