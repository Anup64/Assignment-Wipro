package com.example.billing_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.billing_service.model.Billing;
import com.example.billing_service.service.BillingService;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    // Create Invoice
    @PostMapping
    public ResponseEntity<Billing> createInvoice(@RequestBody Billing billing) {
        return ResponseEntity.ok(billingService.createInvoice(billing));
    }

    // Get All Invoices
    @GetMapping
    public ResponseEntity<List<Billing>> getAllInvoices() {
        return ResponseEntity.ok(billingService.getAllInvoices());
    }

    // Get Invoice by Number
    @GetMapping("/{invoiceNumber}")
    public ResponseEntity<Billing> getInvoice(@PathVariable String invoiceNumber) {
        return billingService.getInvoiceByNumber(invoiceNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update Payment Status
    @PutMapping("/{invoiceNumber}/payment")
    public ResponseEntity<Billing> updatePaymentStatus(@PathVariable String invoiceNumber, @RequestParam String status) {
        return ResponseEntity.ok(billingService.updatePaymentStatus(invoiceNumber, status));
    }

    // Update Insurance Status
    @PutMapping("/{invoiceNumber}/insurance")
    public ResponseEntity<Billing> updateInsuranceStatus(@PathVariable String invoiceNumber, @RequestParam String status) {
        return ResponseEntity.ok(billingService.updateInsuranceStatus(invoiceNumber, status));
    }

    // Delete Invoice
    @DeleteMapping("/{invoiceNumber}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable String invoiceNumber) {
        billingService.deleteInvoice(invoiceNumber);
        return ResponseEntity.noContent().build();
    }
}