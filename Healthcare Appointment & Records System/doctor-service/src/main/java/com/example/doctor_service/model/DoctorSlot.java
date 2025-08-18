package com.example.doctor_service.model;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "doctor_slots",
       uniqueConstraints = @UniqueConstraint(name = "uq_doc_slot", columnNames = {"doctor_id","slot_start"}))
public class DoctorSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "slot_start", nullable = false)
    private OffsetDateTime slotStart;

    @Column(name = "slot_end", nullable = false)
    private OffsetDateTime slotEnd;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.AVAILABLE;
    public enum Status { AVAILABLE, HELD, BOOKED, CANCELLED }

    @Column(length = 60)
    private String holdToken;

    private OffsetDateTime holdExpiresAt;

    public DoctorSlot() {}

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    public OffsetDateTime getSlotStart() { return slotStart; }
    public void setSlotStart(OffsetDateTime slotStart) { this.slotStart = slotStart; }
    public OffsetDateTime getSlotEnd() { return slotEnd; }
    public void setSlotEnd(OffsetDateTime slotEnd) { this.slotEnd = slotEnd; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public String getHoldToken() { return holdToken; }
    public void setHoldToken(String holdToken) { this.holdToken = holdToken; }
    public OffsetDateTime getHoldExpiresAt() { return holdExpiresAt; }
    public void setHoldExpiresAt(OffsetDateTime holdExpiresAt) { this.holdExpiresAt = holdExpiresAt; }
}