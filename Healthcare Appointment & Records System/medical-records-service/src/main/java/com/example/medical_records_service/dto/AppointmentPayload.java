package com.example.medical_records_service.dto;

import java.time.OffsetDateTime;

public class AppointmentPayload {
    private String externalId;
    private String patientId;
    private String doctorId;
    private OffsetDateTime slotStart;
    private OffsetDateTime slotEnd;
    private String status;

    public AppointmentPayload(){}

    public String getExternalId(){return externalId;} public void setExternalId(String v){this.externalId=v;}
    public String getPatientId(){return patientId;} public void setPatientId(String v){this.patientId=v;}
    public String getDoctorId(){return doctorId;} public void setDoctorId(String v){this.doctorId=v;}
    public OffsetDateTime getSlotStart(){return slotStart;} public void setSlotStart(OffsetDateTime v){this.slotStart=v;}
    public OffsetDateTime getSlotEnd(){return slotEnd;} public void setSlotEnd(OffsetDateTime v){this.slotEnd=v;}
    public String getStatus(){return status;} public void setStatus(String v){this.status=v;}
}