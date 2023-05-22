package course.service;

import course.entity.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    void updateCustomerById(Long id, Customer customer);

    void deleteCustomerById(Long id);

    void assign(Long idC, Long idA);
}
