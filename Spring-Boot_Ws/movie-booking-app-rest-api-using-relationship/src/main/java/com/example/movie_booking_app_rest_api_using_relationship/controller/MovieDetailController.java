package com.example.movie_booking_app_rest_api_using_relationship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie_booking_app_rest_api_using_relationship.model.MovieDetail;
import com.example.movie_booking_app_rest_api_using_relationship.service.MovieDetailService;

@RestController
@RequestMapping("/moviedetails")
public class MovieDetailController {
    @Autowired
    private MovieDetailService movieDetailService;

    @PostMapping
    public MovieDetail createMovieDetail(@RequestBody MovieDetail detail) {
        return movieDetailService.saveMovieDetail(detail);
    }

    @GetMapping
    public List<MovieDetail> getAllDetails() {
        return movieDetailService.getAllDetails();
    }
}
