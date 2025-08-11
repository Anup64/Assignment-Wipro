package com.example.ecommerce_app.repository;

import com.example.ecommerce_app.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}