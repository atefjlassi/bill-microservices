package customer.service.web;

import customer.service.dto.CustomerRequestDTO;
import customer.service.dto.CustomerResponseDTO;
import customer.service.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestAPI {

    CustomerService customerService;

    @Autowired
    public CustomerRestAPI(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> allCustomers() {
        return customerService.listCustomers();
    }

    @PostMapping("/customers")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO) {
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDTO);
    }

    @GetMapping("/customers/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable("id") String id) {
        return customerService.getCustomer(id);
    }

    @PutMapping("/customers")
    public CustomerResponseDTO updateCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        return customerService.update(customerRequestDTO);
    }

    @GetMapping("/customers/emails")
    public List<String> getAllCustomerEmails() {
        return customerService.getAllCustomerEmails();
    }
}
