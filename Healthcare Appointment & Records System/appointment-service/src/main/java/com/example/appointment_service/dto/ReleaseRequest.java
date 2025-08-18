package com.example.appointment_service.dto;

public class ReleaseRequest {
    private String holdToken;

    public ReleaseRequest() {}
    public ReleaseRequest(String t) { this.holdToken = t; }

    public String getHoldToken() { return holdToken; }
    public void setHoldToken(String v) { this.holdToken = v; }
}