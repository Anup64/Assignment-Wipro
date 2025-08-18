package com.example.patient_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String externalId;  // UUID for public use

    private String firstName;
    private String lastName;
    private String gender;
    private int age;

    private String contactNumber;
    private String email;
    private String address;

    private String insuranceProvider;
    private String insuranceNumber;

    // ✅ Constructors
    public Patient() {}

    public Patient(String externalId, String firstName, String lastName, String gender, int age,
                   String contactNumber, String email, String address,
                   String insuranceProvider, String insuranceNumber) {
        this.externalId = externalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.insuranceProvider = insuranceProvider;
        this.insuranceNumber = insuranceNumber;
    }

    // ✅ Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getExternalId() { return externalId; }

    public void setExternalId(String externalId) { this.externalId = externalId; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getContactNumber() { return contactNumber; }

    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getInsuranceProvider() { return insuranceProvider; }

    public void setInsuranceProvider(String insuranceProvider) { this.insuranceProvider = insuranceProvider; }

    public String getInsuranceNumber() { return insuranceNumber; }

    public void setInsuranceNumber(String insuranceNumber) { this.insuranceNumber = insuranceNumber; }
}