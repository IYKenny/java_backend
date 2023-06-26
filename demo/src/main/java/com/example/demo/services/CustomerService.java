package com.example.demo.services;

import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) throws ChangeSetPersister.NotFoundException {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customer) throws ChangeSetPersister.NotFoundException {
        Customer existingCustomer = getCustomerById(id);
        existingCustomer.setFirstname(customer.getFirstname());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPassword(customer.getPassword());
        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomer(Long id) throws ChangeSetPersister.NotFoundException {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }
}
