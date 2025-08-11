package com.example.movie_booking_app_rest_api_using_relationship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie_booking_app_rest_api_using_relationship.model.Theater;
import com.example.movie_booking_app_rest_api_using_relationship.service.TheaterService;

@RestController
@RequestMapping("/theaters")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;

    @PostMapping
    public Theater createTheater(@RequestBody Theater theater) {
        return theaterService.saveTheater(theater);
    }

    @GetMapping
    public List<Theater> getAllTheaters() {
        return theaterService.getAllTheaters();
    }
}
