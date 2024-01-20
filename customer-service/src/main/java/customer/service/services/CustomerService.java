package customer.service.services;

import customer.service.dto.CustomerRequestDTO;
import customer.service.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
     CustomerResponseDTO save(CustomerRequestDTO requestDTO);
     CustomerResponseDTO getCustomer(String id);
     CustomerResponseDTO update(CustomerRequestDTO requestDTO);
     List<CustomerResponseDTO> listCustomers();

     List<String> getAllCustomerEmails();
}
