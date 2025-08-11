package com.example.movie_booking_app_rest_api_using_relationship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_booking_app_rest_api_using_relationship.model.MovieDetail;
import com.example.movie_booking_app_rest_api_using_relationship.repository.MovieDetailRepository;

@Service
public class MovieDetailService {
    @Autowired
    private MovieDetailRepository detailRepository;

    public MovieDetail saveMovieDetail(MovieDetail detail) {
        return detailRepository.save(detail);
    }

    public List<MovieDetail> getAllDetails() {
        return detailRepository.findAll();
    }
}
