package com.example.booking_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booking_service.model.Booking;
import com.example.booking_service.repository.BookingRepository;

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