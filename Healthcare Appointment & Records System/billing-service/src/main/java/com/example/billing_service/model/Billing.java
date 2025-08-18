package com.example.billing_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "billing")
public class Billing {

    @Id
    private String id;

    private String invoiceNumber;   // Unique invoice reference
    private String patientId;       // From Patient Service
    private String appointmentId;   // From Appointment Service
    private double totalAmount;
    private String paymentStatus;   // PENDING, PAID, FAILED
    private String insuranceClaimStatus; // SUBMITTED, APPROVED, REJECTED
    private LocalDateTime createdAt;

    private List<String> services;  // e.g. "Consultation", "X-Ray", "Medicine"

    // Constructors
    public Billing() {}

    public Billing(String invoiceNumber, String patientId, String appointmentId,
                   double totalAmount, String paymentStatus,
                   String insuranceClaimStatus, LocalDateTime createdAt, List<String> services) {
        this.invoiceNumber = invoiceNumber;
        this.patientId = patientId;
        this.appointmentId = appointmentId;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.insuranceClaimStatus = insuranceClaimStatus;
        this.createdAt = createdAt;
        this.services = services;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public String getInsuranceClaimStatus() { return insuranceClaimStatus; }
    public void setInsuranceClaimStatus(String insuranceClaimStatus) { this.insuranceClaimStatus = insuranceClaimStatus; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<String> getServices() { return services; }
    public void setServices(List<String> services) { this.services = services; }
}