package com.example.movie_booking_app_rest_api_using_relationship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_booking_app_rest_api_using_relationship.model.Theater;
import com.example.movie_booking_app_rest_api_using_relationship.repository.TheaterRepository;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    public Theater saveTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }
}

