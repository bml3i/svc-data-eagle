package blog.leobi.dataeagle.mapper;

import blog.leobi.dataeagle.dto.CustomerDTO;
import blog.leobi.dataeagle.entity.Customer;

public class CustomerMapper {

    public static CustomerDTO toCustomerDTO(Customer customer, CustomerDTO customerDTO) {
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setMobileNumber(customer.getMobileNumber());
        return customerDTO;
    }

    public static Customer toCustomer(CustomerDTO customerDTO, Customer customer) {
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setMobileNumber(customerDTO.getMobileNumber());
        return customer;
    }
}
