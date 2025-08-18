package com.example.doctor_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.doctor_service.model.Doctor;
import com.example.doctor_service.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    // Constructor injection
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<Doctor> create(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.createDoctor(doctor));
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAll() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/{externalId}")
    public ResponseEntity<Doctor> getById(@PathVariable String externalId) {
        return doctorService.getDoctorByExternalId(externalId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{externalId}")
    public ResponseEntity<Doctor> update(@PathVariable String externalId, @RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.updateDoctor(externalId, doctor));
    }

    @DeleteMapping("/{externalId}")
    public ResponseEntity<Void> delete(@PathVariable String externalId) {
        doctorService.deleteDoctor(externalId);
        return ResponseEntity.noContent().build();
    }
}