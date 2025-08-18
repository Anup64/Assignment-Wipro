package com.example.doctor_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctor_service.model.Doctor;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByExternalId(String externalId);
}