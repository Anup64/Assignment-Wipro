package com.example.patient_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.patient_service.model.Patient;
import com.example.patient_service.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<Patient> create(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.createPatient(patient));
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAll() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{externalId}")
    public ResponseEntity<Patient> getById(@PathVariable String externalId) {
        return patientService.getPatientByExternalId(externalId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{externalId}")
    public ResponseEntity<Patient> update(@PathVariable String externalId, @RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.updatePatient(externalId, patient));
    }
    @DeleteMapping("/{externalId}")
    public ResponseEntity<Void> delete(@PathVariable String externalId) {
        patientService.deletePatient(externalId);
        return ResponseEntity.noContent().build();
    }
}