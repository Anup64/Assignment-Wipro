package com.example.medical_records_service.service;

import org.springframework.stereotype.Service;

import com.example.medical_records_service.model.MedicalRecord;
import com.example.medical_records_service.repository.MedicalRecordRepository;

import java.util.*;

@Service
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public MedicalRecord createRecord(MedicalRecord record) {
        record.setExternalId(UUID.randomUUID().toString());
        return medicalRecordRepository.save(record);
    }

    public List<MedicalRecord> getAllRecords() {
        return medicalRecordRepository.findAll();
    }
    
    public Optional<MedicalRecord> getRecordByExternalId(String externalId) {
        return medicalRecordRepository.findByExternalId(externalId);
    }

    public List<MedicalRecord> getRecordsByPatient(String patientId) {
        return medicalRecordRepository.findByPatientId(patientId);
    }

    public MedicalRecord updateRecord(String externalId, MedicalRecord updated) {
        return medicalRecordRepository.findByExternalId(externalId)
                .map(existing -> {
                    existing.setVisitDate(updated.getVisitDate());
                    existing.setDiagnosis(updated.getDiagnosis());
                    existing.setPrescription(updated.getPrescription());
                    existing.setTestResults(updated.getTestResults());
                    return medicalRecordRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Record not found: " + externalId));
    }

    public void deleteRecord(String externalId) {
        medicalRecordRepository.findByExternalId(externalId)
                .ifPresent(medicalRecordRepository::delete);
    }
}