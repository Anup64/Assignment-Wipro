package com.example.booking_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.booking_service.model.Booking;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCustomerId(Long customerId);
}
