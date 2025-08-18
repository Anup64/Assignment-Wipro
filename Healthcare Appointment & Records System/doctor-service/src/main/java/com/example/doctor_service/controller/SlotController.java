package com.example.doctor_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.doctor_service.dto.ConfirmRequest;
import com.example.doctor_service.dto.HoldRequest;
import com.example.doctor_service.dto.HoldResponse;
import com.example.doctor_service.dto.ReleaseRequest;
import com.example.doctor_service.model.DoctorSlot;
import com.example.doctor_service.repository.DoctorSlotRepository;
import com.example.doctor_service.service.SlotService;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class SlotController {

    private final SlotService slotService;
    private final DoctorSlotRepository slotRepo;

    public SlotController(SlotService slotService, DoctorSlotRepository slotRepo) {
        this.slotService = slotService; this.slotRepo = slotRepo;
    }

    @GetMapping("/{externalId}/slots")
    public ResponseEntity<List<DoctorSlot>> slots(@PathVariable String externalId,
                                                  @RequestParam OffsetDateTime from,
                                                  @RequestParam OffsetDateTime to) {
        return ResponseEntity.ok(slotRepo.findByDoctor_ExternalIdAndSlotStartBetween(externalId, from, to));
    }

    @PostMapping("/slots/hold")
    public ResponseEntity<HoldResponse> hold(@RequestBody HoldRequest req) {
        return ResponseEntity.ok(slotService.hold(req));
    }

    @PostMapping("/slots/confirm")
    public ResponseEntity<Void> confirm(@RequestBody ConfirmRequest req) {
        slotService.confirm(req);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/slots/release")
    public ResponseEntity<Void> release(@RequestBody ReleaseRequest req) {
        slotService.release(req);
        return ResponseEntity.ok().build();
    }
}
