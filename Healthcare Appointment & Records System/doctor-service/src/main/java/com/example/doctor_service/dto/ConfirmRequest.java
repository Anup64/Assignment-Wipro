package com.example.doctor_service.dto;

public class ConfirmRequest {
    private String holdToken;

    public ConfirmRequest() {}

    public ConfirmRequest(String t) { this.holdToken = t; }

    public String getHoldToken() { return holdToken; }
    public void setHoldToken(String v) { this.holdToken = v; }
}
