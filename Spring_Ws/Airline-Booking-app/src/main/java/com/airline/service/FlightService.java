package com.airline.service;

import java.util.HashMap;
import java.util.Map;

public class FlightService {

    private Map<String, Integer> flightSeats = new HashMap<>();

    public FlightService() {
        // Simulate flight data: flightNumber -> availableSeats
        flightSeats.put("FL123", 3);
        flightSeats.put("FL456", 0);
    }

    public boolean isSeatAvailable(String flightNumber) {
        return flightSeats.getOrDefault(flightNumber, 0) > 0;
    }

    public void bookSeat(String flightNumber) {
        if (isSeatAvailable(flightNumber)) {
            flightSeats.put(flightNumber, flightSeats.get(flightNumber) - 1);
        }
    }

}
