package com.example.appointment_service.dto;

import java.time.OffsetDateTime;

public class HoldResponse {
    private String holdToken;
    private OffsetDateTime expiresAt;

    public HoldResponse() {}

    public HoldResponse(String t, OffsetDateTime e) {
        this.holdToken = t;
        this.expiresAt = e;
    }

    public String getHoldToken() { return holdToken; }
    public void setHoldToken(String v) { this.holdToken = v; }
    public OffsetDateTime getExpiresAt() { return expiresAt; }
    public void setExpiresAt(OffsetDateTime v) { this.expiresAt = v; }
}