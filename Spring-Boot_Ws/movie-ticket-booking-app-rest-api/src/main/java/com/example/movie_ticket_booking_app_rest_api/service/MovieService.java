package com.example.movie_ticket_booking_app_rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_ticket_booking_app_rest_api.model.Movie;
import com.example.movie_ticket_booking_app_rest_api.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> getAll() { return movieRepository.findAll(); }
    public Movie getById(Long id) { return movieRepository.findById(id).orElse(null); }
    public Movie save(Movie movie) { return movieRepository.save(movie); }
    public void delete(Long id) { movieRepository.deleteById(id); }
}
