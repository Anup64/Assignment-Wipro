package com.example.movie_booking_app_rest_api_using_relationship.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;

    @ManyToMany(mappedBy = "movies")
    private List<Theater> theaters;

    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL)
    private MovieDetail detail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Theater> getTheaters() {
		return theaters;
	}

	public void setTheaters(List<Theater> theaters) {
		this.theaters = theaters;
	}

	public MovieDetail getDetail() {
		return detail;
	}

	public void setDetail(MovieDetail detail) {
		this.detail = detail;
	}

    // Getters and Setters
    
    
}
