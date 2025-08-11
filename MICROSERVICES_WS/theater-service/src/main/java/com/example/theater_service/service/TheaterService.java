package com.example.theater_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theater_service.model.Theater;
import com.example.theater_service.repository.TheaterRepository;

import java.util.List;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;
    public List<Theater> getAll() { return theaterRepository.findAll(); }
    public Theater getById(Long id) { return theaterRepository.findById(id).orElse(null); }
    public Theater save(Theater theater) { return theaterRepository.save(theater); }
    public void delete(Long id) { theaterRepository.deleteById(id); }
}

