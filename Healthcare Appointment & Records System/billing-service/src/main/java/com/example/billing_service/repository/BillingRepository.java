package com.example.billing_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.billing_service.model.Billing;

import java.util.Optional;

public interface BillingRepository extends MongoRepository<Billing, String> {
    Optional<Billing> findByInvoiceNumber(String invoiceNumber);
}