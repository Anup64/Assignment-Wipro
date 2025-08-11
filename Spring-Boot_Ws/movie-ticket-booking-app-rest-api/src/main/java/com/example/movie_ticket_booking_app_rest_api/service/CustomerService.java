package com.example.movie_ticket_booking_app_rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_ticket_booking_app_rest_api.model.Customer;
import com.example.movie_ticket_booking_app_rest_api.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public List<Customer> getAll() { return customerRepository.findAll(); }
    public Customer getById(Long id) { return customerRepository.findById(id).orElse(null); }
    public Customer save(Customer customer) { return customerRepository.save(customer); }
    public void delete(Long id) { customerRepository.deleteById(id); }
}
