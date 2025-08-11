package com.example.movie_ticket_booking_app_rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_ticket_booking_app_rest_api.model.Booking;
import com.example.movie_ticket_booking_app_rest_api.repository.BookingRepository;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    public List<Booking> getAll() { return bookingRepository.findAll(); }
    public Booking getById(Long id) { return bookingRepository.findById(id).orElse(null); }
    public Booking save(Booking booking) { return bookingRepository.save(booking); }
    public void delete(Long id) { bookingRepository.deleteById(id); }
    public List<Booking> getByCustomerId(Long customerId) { return bookingRepository.findByCustomerId(customerId); }
}


