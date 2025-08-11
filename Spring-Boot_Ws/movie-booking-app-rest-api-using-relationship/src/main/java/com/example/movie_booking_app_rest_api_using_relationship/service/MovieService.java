package com.example.movie_booking_app_rest_api_using_relationship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_booking_app_rest_api_using_relationship.model.Movie;
import com.example.movie_booking_app_rest_api_using_relationship.repository.MovieRepository;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
}

