package com.example.appointment_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.appointment_service.model.Appointment;
import com.example.appointment_service.service.AppointmentService;

import java.time.OffsetDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService service;
    public AppointmentController(AppointmentService service){ this.service = service; }

    @PostMapping
    public ResponseEntity<Appointment> book(@RequestBody Appointment req){
        return ResponseEntity.ok(service.book(req));
    }

    @GetMapping("/{externalId}")
    public ResponseEntity<Appointment> get(@PathVariable String externalId){
        Optional<Appointment> a = service.getByExternalId(externalId);
        return a.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{externalId}/reschedule")
    public ResponseEntity<Appointment> reschedule(@PathVariable String externalId,
                                                  @RequestParam OffsetDateTime newStart,
                                                  @RequestParam OffsetDateTime newEnd){
        return ResponseEntity.ok(service.reschedule(externalId, newStart, newEnd));
    }

    @DeleteMapping("/{externalId}")
    public ResponseEntity<Void> cancel(@PathVariable String externalId){
        service.cancel(externalId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{externalId}/complete")
    public ResponseEntity<Appointment> complete(@PathVariable String externalId){
        return ResponseEntity.ok(service.complete(externalId));
    }
}