package com.example.appointment_service.model;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String externalId;

    @Column(nullable = false) private String patientId;
    @Column(nullable = false) private String doctorId;

    @Column(nullable = false) private OffsetDateTime slotStart;
    @Column(nullable = false) private OffsetDateTime slotEnd;

    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Status status = Status.PENDING;

    @Column(length = 60) private String holdToken; // from Doctor Service

    public enum Status { PENDING, CONFIRMED, RESCHEDULED, CANCELLED, COMPLETED }

    public Appointment() {}

    // getters/setters
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getExternalId(){return externalId;} public void setExternalId(String v){this.externalId=v;}
    public String getPatientId(){return patientId;} public void setPatientId(String v){this.patientId=v;}
    public String getDoctorId(){return doctorId;} public void setDoctorId(String v){this.doctorId=v;}
    public OffsetDateTime getSlotStart(){return slotStart;} public void setSlotStart(OffsetDateTime v){this.slotStart=v;}
    public OffsetDateTime getSlotEnd(){return slotEnd;} public void setSlotEnd(OffsetDateTime v){this.slotEnd=v;}
    public Status getStatus(){return status;} public void setStatus(Status v){this.status=v;}
    public String getHoldToken(){return holdToken;} public void setHoldToken(String v){this.holdToken=v;}
}