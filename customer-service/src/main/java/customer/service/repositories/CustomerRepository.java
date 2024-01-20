package customer.service.repositories;

import customer.service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(value = "select email from CUSTOMER", nativeQuery = true)
    List<String> getAllCustomerEmails();

}
