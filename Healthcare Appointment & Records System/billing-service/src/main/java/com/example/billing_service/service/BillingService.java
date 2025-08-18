package com.example.billing_service.service;

import org.springframework.stereotype.Service;

import com.example.billing_service.model.Billing;
import com.example.billing_service.repository.BillingRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BillingService {

    private final BillingRepository billingRepository;

    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    // Create invoice
    public Billing createInvoice(Billing billing) {
        billing.setInvoiceNumber(UUID.randomUUID().toString());
        billing.setCreatedAt(LocalDateTime.now());
        billing.setPaymentStatus("PENDING");
        billing.setInsuranceClaimStatus("SUBMITTED");
        return billingRepository.save(billing);
    }

    // Get all invoices
    public List<Billing> getAllInvoices() {
        return billingRepository.findAll();
    }

    // Get invoice by invoice number
    public Optional<Billing> getInvoiceByNumber(String invoiceNumber) {
        return billingRepository.findByInvoiceNumber(invoiceNumber);
    }

    // Update payment status
    public Billing updatePaymentStatus(String invoiceNumber, String status) {
        return billingRepository.findByInvoiceNumber(invoiceNumber)
                .map(existing -> {
                    existing.setPaymentStatus(status);
                    return billingRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Invoice not found: " + invoiceNumber));
    }

    // Update insurance claim status
    public Billing updateInsuranceStatus(String invoiceNumber, String status) {
        return billingRepository.findByInvoiceNumber(invoiceNumber)
                .map(existing -> {
                    existing.setInsuranceClaimStatus(status);
                    return billingRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Invoice not found: " + invoiceNumber));
    }

    // Delete invoice
    public void deleteInvoice(String invoiceNumber) {
        billingRepository.findByInvoiceNumber(invoiceNumber)
                .ifPresent(billingRepository::delete);
    }
}
