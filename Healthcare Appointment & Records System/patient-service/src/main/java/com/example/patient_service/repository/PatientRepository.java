package com.example.patient_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.patient_service.model.Patient;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByExternalId(String externalId);
}
