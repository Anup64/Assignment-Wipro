package com.example.doctor_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctor_service.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}