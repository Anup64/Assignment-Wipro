package com.example.movie_customer_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_customer_service.model.MovieCustomer;
import com.example.movie_customer_service.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public List<MovieCustomer> getAll() { return customerRepository.findAll(); }
    public MovieCustomer getById(Long id) { return customerRepository.findById(id).orElse(null); }
    public MovieCustomer save(MovieCustomer customer) { return customerRepository.save(customer); }
    public void delete(Long id) { customerRepository.deleteById(id); }
	
}