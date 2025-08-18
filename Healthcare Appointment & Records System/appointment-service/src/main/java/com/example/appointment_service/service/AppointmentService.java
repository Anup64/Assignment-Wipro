package com.example.appointment_service.service;

import com.example.appointment_service.dto.ConfirmRequest;
import com.example.appointment_service.dto.HoldRequest;
import com.example.appointment_service.dto.HoldResponse;
import com.example.appointment_service.dto.ReleaseRequest;
import com.example.appointment_service.event.AppointmentEventProducer;
import com.example.appointment_service.model.Appointment;
import com.example.appointment_service.repository.AppointmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

    private final AppointmentRepository repo;
    private final RestTemplate rest;
    private final AppointmentEventProducer producer;
    private final ObjectMapper mapper = new ObjectMapper();

    // point this to your Doctor Service base URL
    private final String doctorServiceBase = "http://localhost:7777";

    public AppointmentService(AppointmentRepository repo, AppointmentEventProducer producer) {
        this.repo = repo;
        this.producer = producer;
        this.rest = new RestTemplate();
    }

    public Appointment book(Appointment req) {
        req.setExternalId(UUID.randomUUID().toString());
        req.setStatus(Appointment.Status.PENDING);

        // 1) HOLD slot in Doctor Service (if fails → no appointment persisted)
        HoldRequest hold = new HoldRequest(req.getDoctorId(), req.getSlotStart(), req.getSlotEnd(), UUID.randomUUID().toString());
        HoldResponse holdRes;
        try {
            holdRes = rest.postForEntity(doctorServiceBase + "/doctors/slots/hold", hold, HoldResponse.class).getBody();
            if (holdRes == null || holdRes.getHoldToken() == null) throw new RuntimeException("Hold failed");
        } catch (Exception e) {
            throw new RuntimeException("Doctor slot hold failed: " + e.getMessage());
        }
        req.setHoldToken(holdRes.getHoldToken());

        // 2) Save appointment as PENDING, then confirm slot
        Appointment saved = repo.save(req);
        try {
            rest.postForEntity(doctorServiceBase + "/doctors/slots/confirm",
                    new ConfirmRequest(holdRes.getHoldToken()), Void.class);

            saved.setStatus(Appointment.Status.CONFIRMED);
            repo.save(saved);

            // 3) Publish async event
            producer.publish(AppointmentEventProducer.TOPIC_CONFIRMED,
                    mapper.writeValueAsString(saved));

            return saved;

        } catch (Exception e) {
            // Confirm failed → release and rollback appointment
            try {
                rest.postForEntity(doctorServiceBase + "/doctors/slots/release",
                        new ReleaseRequest(holdRes.getHoldToken()), Void.class);
            } catch (Exception ignore) {}
            repo.deleteById(saved.getId());
            throw new RuntimeException("Booking failed & rolled back: " + e.getMessage());
        }
    }

    public Optional<Appointment> getByExternalId(String id){ return repo.findByExternalId(id); }

    public Appointment reschedule(String externalId, OffsetDateTime newStart, OffsetDateTime newEnd) {
        Appointment appt = repo.findByExternalId(externalId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        // Simple approach: cancel old slot (no-op here) and book new slot (hold+confirm)
        // Release previous? Only if it was confirmed; but doctor slot already BOOKED.
        // In real life, you'd cancel and create new; here we do a new hold+confirm.
        HoldRequest hold = new HoldRequest(appt.getDoctorId(), newStart, newEnd, UUID.randomUUID().toString());
        HoldResponse holdRes = rest.postForEntity(doctorServiceBase + "/doctors/slots/hold", hold, HoldResponse.class).getBody();
        if (holdRes == null || holdRes.getHoldToken() == null) throw new RuntimeException("Hold failed");

        try {
            rest.postForEntity(doctorServiceBase + "/doctors/slots/confirm",
                    new ConfirmRequest(holdRes.getHoldToken()), Void.class);

            appt.setSlotStart(newStart);
            appt.setSlotEnd(newEnd);
            appt.setStatus(Appointment.Status.RESCHEDULED);
            appt.setHoldToken(null);
            return repo.save(appt);
        } catch (Exception e) {
            try { rest.postForEntity(doctorServiceBase + "/doctors/slots/release",
                    new ReleaseRequest(holdRes.getHoldToken()), Void.class); } catch (Exception ignore) {}
            throw new RuntimeException("Reschedule failed: " + e.getMessage());
        }
    }

    public void cancel(String externalId) {
        repo.findByExternalId(externalId).ifPresent(a -> {
            a.setStatus(Appointment.Status.CANCELLED);
            repo.save(a);
            try {
                producer.publish(AppointmentEventProducer.TOPIC_CANCELLED, mapper.writeValueAsString(a));
            } catch (Exception ignored) {}
        });
    }

    public Appointment complete(String externalId) {
        Appointment a = repo.findByExternalId(externalId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        a.setStatus(Appointment.Status.COMPLETED);
        Appointment saved = repo.save(a);
        try {
            producer.publish(AppointmentEventProducer.TOPIC_COMPLETED, mapper.writeValueAsString(saved));
        } catch (Exception ignored) {}
        return saved;
    }
}