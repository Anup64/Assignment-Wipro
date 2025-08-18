package com.example.doctor_service.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.doctor_service.dto.ConfirmRequest;
import com.example.doctor_service.dto.HoldRequest;
import com.example.doctor_service.dto.HoldResponse;
import com.example.doctor_service.dto.ReleaseRequest;
import com.example.doctor_service.model.DoctorSlot;
import com.example.doctor_service.repository.DoctorSlotRepository;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class SlotService {

    private final DoctorSlotRepository slotRepo;

    public SlotService(DoctorSlotRepository slotRepo) { this.slotRepo = slotRepo; }

    @Transactional
    public HoldResponse hold(HoldRequest req) {
        DoctorSlot slot = slotRepo.findByDoctor_ExternalIdAndSlotStart(req.getDoctorExternalId(), req.getSlotStart())
            .orElseThrow(() -> new IllegalArgumentException("Slot not found"));

        if (slot.getStatus() == DoctorSlot.Status.HELD && slot.getHoldExpiresAt() != null
                && slot.getHoldExpiresAt().isBefore(OffsetDateTime.now())) {
            slot.setStatus(DoctorSlot.Status.AVAILABLE);
            slot.setHoldToken(null);
            slot.setHoldExpiresAt(null);
        }
        if (slot.getStatus() != DoctorSlot.Status.AVAILABLE) {
            throw new IllegalStateException("Slot not available");
        }
        if (!slot.getSlotEnd().equals(req.getSlotEnd())) {
            throw new IllegalArgumentException("Slot end mismatch");
        }

        String token = UUID.randomUUID().toString();
        slot.setStatus(DoctorSlot.Status.HELD);
        slot.setHoldToken(token);
        slot.setHoldExpiresAt(OffsetDateTime.now().plusMinutes(5));
        slotRepo.save(slot);
        return new HoldResponse(token, slot.getHoldExpiresAt());
    }

    @Transactional
    public void confirm(ConfirmRequest req) {
        DoctorSlot slot = slotRepo.findByHoldToken(req.getHoldToken())
            .orElseThrow(() -> new IllegalArgumentException("Invalid hold token"));
        if (slot.getStatus() != DoctorSlot.Status.HELD) throw new IllegalStateException("Not on hold");
        if (slot.getHoldExpiresAt() != null && slot.getHoldExpiresAt().isBefore(OffsetDateTime.now()))
            throw new IllegalStateException("Hold expired");

        slot.setStatus(DoctorSlot.Status.BOOKED);
        slot.setHoldExpiresAt(null);
        slotRepo.save(slot);
    }

    @Transactional
    public void release(ReleaseRequest req) {
        DoctorSlot slot = slotRepo.findByHoldToken(req.getHoldToken())
            .orElseThrow(() -> new IllegalArgumentException("Invalid hold token"));
        slot.setStatus(DoctorSlot.Status.AVAILABLE);
        slot.setHoldToken(null);
        slot.setHoldExpiresAt(null);
        slotRepo.save(slot);
    }
}