package com.example.movie_ticket_booking_app_rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_ticket_booking_app_rest_api.model.Theater;
import com.example.movie_ticket_booking_app_rest_api.repository.TheaterRepository;

import java.util.List;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;
    public List<Theater> getAll() { return theaterRepository.findAll(); }
    public Theater getById(Long id) { return theaterRepository.findById(id).orElse(null); }
    public Theater save(Theater theater) { return theaterRepository.save(theater); }
    public void delete(Long id) { theaterRepository.deleteById(id); }
}
