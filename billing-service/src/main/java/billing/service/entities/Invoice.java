package billing.service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    private String id;
    private LocalDate date;
    private BigDecimal amount;
    private String customerId;
    @Transient
    private Customer customer;
}
