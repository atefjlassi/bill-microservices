package customer.service.services;

import customer.service.dto.CustomerRequestDTO;
import customer.service.dto.CustomerResponseDTO;
import customer.service.entities.Customer;
import customer.service.mappers.CustomerMapper;
import customer.service.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO requestDTO) {

        Customer customer = customerMapper.customerRequestDTOtoCustomer(requestDTO);
        Customer savedCustomer = customerRepository.save(customer);
        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(savedCustomer);

        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(customer);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO requestDTO) {
        Customer customer = customerMapper.customerRequestDTOtoCustomer(requestDTO);
        Customer updatedCustomer = customerRepository.save(customer);
        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(updatedCustomer);
        return customerResponseDTO;
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> customersResponseDto = customers.stream()
                    .map(customerMapper::customerToCustomerResponseDTO).collect(Collectors.toList());
        return customersResponseDto;
    }

    @Override
    public List<String> getAllCustomerEmails() {
        return customerRepository.getAllCustomerEmails();
    }
}
