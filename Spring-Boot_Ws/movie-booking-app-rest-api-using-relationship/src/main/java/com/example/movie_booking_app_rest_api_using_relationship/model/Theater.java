package com.example.movie_booking_app_rest_api_using_relationship.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    @ManyToMany
    @JoinTable(
        name = "movie_theater",
        joinColumns = @JoinColumn(name = "theater_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

    // Getters and Setters
    
    
}
