package com.example.medical_records_service.consumer;

import com.example.medical_records_service.dto.AppointmentPayload;
import com.example.medical_records_service.model.MedicalRecord;
import com.example.medical_records_service.repository.MedicalRecordRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class AppointmentCompletedListener {

    private final MedicalRecordRepository repo;
    private final ObjectMapper mapper = new ObjectMapper();

    public AppointmentCompletedListener(MedicalRecordRepository repo){ this.repo = repo; }

    @KafkaListener(topics = "appointment-completed", groupId = "medical-records-group")
    public void onCompleted(String payload) {
        try {
            AppointmentPayload p = mapper.readValue(payload, AppointmentPayload.class);
            MedicalRecord r = new MedicalRecord();
            r.setExternalId(UUID.randomUUID().toString());
            r.setPatientId(p.getPatientId());
            r.setDoctorId(p.getDoctorId());
            r.setVisitDate(LocalDateTime.now());
            r.setDiagnosis("");     // to be filled by doctor UI later
            r.setPrescription("");  // ""
            r.setTestResults("");   // ""
            repo.save(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}