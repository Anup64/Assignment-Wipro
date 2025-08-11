package com.example.movie_ticket_booking_app_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movie_ticket_booking_app_rest_api.model.Booking;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCustomerId(Long customerId);
}
