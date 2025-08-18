package com.example.patient_service.service;

import org.springframework.stereotype.Service;

import com.example.patient_service.model.Patient;
import com.example.patient_service.repository.PatientRepository;

import java.util.*;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient createPatient(Patient patient) {
        patient.setExternalId(UUID.randomUUID().toString());
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientByExternalId(String externalId) {
        return patientRepository.findByExternalId(externalId);
    }

    public Patient updatePatient(String externalId, Patient updatedPatient) {
        return patientRepository.findByExternalId(externalId)
                .map(existing -> {
                    existing.setFirstName(updatedPatient.getFirstName());
                    existing.setLastName(updatedPatient.getLastName());
                    existing.setGender(updatedPatient.getGender());
                    existing.setAge(updatedPatient.getAge());
                    existing.setContactNumber(updatedPatient.getContactNumber());
                    existing.setEmail(updatedPatient.getEmail());
                    existing.setAddress(updatedPatient.getAddress());
                    existing.setInsuranceProvider(updatedPatient.getInsuranceProvider());
                    existing.setInsuranceNumber(updatedPatient.getInsuranceNumber());
                    return patientRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + externalId));
    }

    public void deletePatient(String externalId) {
        patientRepository.findByExternalId(externalId)
                .ifPresent(patientRepository::delete);
    }
}
