package com.example.movie_customer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movie_customer_service.model.MovieCustomer;

public interface CustomerRepository extends JpaRepository<MovieCustomer, Long> {
}
