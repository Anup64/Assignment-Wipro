package com.example.medical_records_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medical_records_service.model.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    Optional<MedicalRecord> findByExternalId(String externalId);
    List<MedicalRecord> findByPatientId(String patientId);
}
