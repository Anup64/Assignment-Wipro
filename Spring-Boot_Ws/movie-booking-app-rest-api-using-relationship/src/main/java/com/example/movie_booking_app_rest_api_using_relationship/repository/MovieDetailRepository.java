package com.example.movie_booking_app_rest_api_using_relationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movie_booking_app_rest_api_using_relationship.model.MovieDetail;

public interface MovieDetailRepository extends JpaRepository<MovieDetail, Long> {}

