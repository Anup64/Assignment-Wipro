package com.example.movie_ticket_booking_app_rest_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie_ticket_booking_app_rest_api.model.Theater;
import com.example.movie_ticket_booking_app_rest_api.service.TheaterService;

@RestController
@RequestMapping("/api/theaters")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;

    @GetMapping
    public List<Theater> getAll() { return theaterService.getAll(); }

    @GetMapping("/{id}")
    public Theater getById(@PathVariable Long id) { return theaterService.getById(id); }

    @PostMapping
    public Theater save(@RequestBody Theater theater) { return theaterService.save(theater); }

    @PutMapping("/{id}")
    public Theater update(@PathVariable Long id, @RequestBody Theater theater) {
        theater.setId(id);
        return theaterService.save(theater);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { theaterService.delete(id); }
}

