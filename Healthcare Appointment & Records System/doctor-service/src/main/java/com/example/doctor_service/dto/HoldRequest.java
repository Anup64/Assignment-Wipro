package com.example.doctor_service.dto;

import java.time.OffsetDateTime;

public class HoldRequest {
    private String doctorExternalId;
    private OffsetDateTime slotStart;
    private OffsetDateTime slotEnd;
    private String requestId; // idempotency (optional)

    public HoldRequest() {}

    public HoldRequest(String d, OffsetDateTime s, OffsetDateTime e, String r) {
        this.doctorExternalId = d;
        this.slotStart = s;
        this.slotEnd = e;
        this.requestId = r;
    }

    public String getDoctorExternalId() { return doctorExternalId; }
    public void setDoctorExternalId(String v) { this.doctorExternalId = v; }
    public OffsetDateTime getSlotStart() { return slotStart; }
    public void setSlotStart(OffsetDateTime v) { this.slotStart = v; }
    public OffsetDateTime getSlotEnd() { return slotEnd; }
    public void setSlotEnd(OffsetDateTime v) { this.slotEnd = v; }
    public String getRequestId() { return requestId; }
    public void setRequestId(String v) { this.requestId = v; }
}