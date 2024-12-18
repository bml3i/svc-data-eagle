package blog.leobi.dataeagle.service;

import blog.leobi.dataeagle.constant.CustomerConst;
import blog.leobi.dataeagle.dto.CustomerDTO;
import blog.leobi.dataeagle.entity.Customer;
import blog.leobi.dataeagle.exception.CustomerAlreadyExistsException;
import blog.leobi.dataeagle.mapper.CustomerMapper;
import blog.leobi.dataeagle.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void createCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.toCustomer(customerDTO, new Customer());
        customer.setCreatedAt(LocalDateTime.now().withNano(0));
        customer.setCreatedBy("admin");

        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDTO.getMobileNumber());

        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException(CustomerConst.CUSTOMER_ALREADY_EXISTS + " & Mobile Number is: " + customerDTO.getMobileNumber());
        }

        customerRepository.save(customer);
    }
}
