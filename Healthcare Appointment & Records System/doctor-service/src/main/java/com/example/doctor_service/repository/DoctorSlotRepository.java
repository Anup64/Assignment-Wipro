package com.example.doctor_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctor_service.model.DoctorSlot;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public interface DoctorSlotRepository extends JpaRepository<DoctorSlot, Long> {
    Optional<DoctorSlot> findByDoctor_ExternalIdAndSlotStart(String doctorExternalId, OffsetDateTime slotStart);
    List<DoctorSlot> findByDoctor_ExternalIdAndSlotStartBetween(String doctorExternalId, OffsetDateTime from, OffsetDateTime to);
    Optional<DoctorSlot> findByHoldToken(String holdToken);
}
