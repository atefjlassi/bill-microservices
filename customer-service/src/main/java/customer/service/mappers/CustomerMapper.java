package customer.service.mappers;

import customer.service.dto.CustomerRequestDTO;
import customer.service.dto.CustomerResponseDTO;
import customer.service.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOtoCustomer(CustomerRequestDTO customerRequestDTO);
}
