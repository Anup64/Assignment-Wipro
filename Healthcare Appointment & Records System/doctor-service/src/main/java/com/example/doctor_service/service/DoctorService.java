package com.example.doctor_service.service;

import org.springframework.stereotype.Service;

import com.example.doctor_service.model.Doctor;
import com.example.doctor_service.repository.DoctorRepository;

import java.util.*;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // CREATE
    public Doctor createDoctor(Doctor doctor) {
        doctor.setExternalId(UUID.randomUUID().toString());
        return doctorRepository.save(doctor);
    }

    // READ ALL
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // READ ONE
    public Optional<Doctor> getDoctorByExternalId(String externalId) {
        return doctorRepository.findByExternalId(externalId);
    }

    // UPDATE
    public Doctor updateDoctor(String externalId, Doctor updatedDoctor) {
        return doctorRepository.findByExternalId(externalId)
                .map(existing -> {
                    existing.setName(updatedDoctor.getName());
                    existing.setSpecialization(updatedDoctor.getSpecialization());
                    existing.setQualification(updatedDoctor.getQualification());
                    existing.setPhone(updatedDoctor.getPhone());
                    existing.setEmail(updatedDoctor.getEmail());
                    return doctorRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + externalId));
    }

    // DELETE
    public void deleteDoctor(String externalId) {
        doctorRepository.findByExternalId(externalId)
                .ifPresent(doctorRepository::delete);
    }
}