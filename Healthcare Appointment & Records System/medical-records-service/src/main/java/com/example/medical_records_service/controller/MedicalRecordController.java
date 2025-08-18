package com.example.medical_records_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.medical_records_service.model.MedicalRecord;
import com.example.medical_records_service.service.MedicalRecordService;

import java.util.List;

@RestController
@RequestMapping("/records")
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @PostMapping
    public ResponseEntity<MedicalRecord> create(@RequestBody MedicalRecord record) {
        return ResponseEntity.ok(medicalRecordService.createRecord(record));
    }

    @GetMapping
    public ResponseEntity<List<MedicalRecord>> getAll() {
        return ResponseEntity.ok(medicalRecordService.getAllRecords());
    }

    @GetMapping("/{externalId}")
    public ResponseEntity<MedicalRecord> getById(@PathVariable String externalId) {
        return medicalRecordService.getRecordByExternalId(externalId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalRecord>> getByPatient(@PathVariable String patientId) {
        return ResponseEntity.ok(medicalRecordService.getRecordsByPatient(patientId));
    }

    @PutMapping("/{externalId}")
    public ResponseEntity<MedicalRecord> update(@PathVariable String externalId, @RequestBody MedicalRecord updated) {
        return ResponseEntity.ok(medicalRecordService.updateRecord(externalId, updated));
    }

    @DeleteMapping("/{externalId}")
    public ResponseEntity<Void> delete(@PathVariable String externalId) {
        medicalRecordService.deleteRecord(externalId);
        return ResponseEntity.noContent().build();
    }
}