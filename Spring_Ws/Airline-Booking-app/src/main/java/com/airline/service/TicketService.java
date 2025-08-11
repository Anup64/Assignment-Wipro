package com.airline.service;

public class TicketService {

    private FlightService flightService;

    // Setter for injection
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    public String confirmBooking(String flightNumber, String userId) {
        if (flightService.isSeatAvailable(flightNumber)) {
            flightService.bookSeat(flightNumber);
            return "Booking confirmed for " + userId + " on " + flightNumber;
        } else {
            return "Flight " + flightNumber + " is full";
        }
    }
}
