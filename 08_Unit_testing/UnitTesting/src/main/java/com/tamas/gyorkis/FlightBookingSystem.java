package com.tamas.gyorkis;

import java.util.HashMap;
import java.util.Map;

public class FlightBookingSystem {
    private Map<String, Flight> flights;

    public FlightBookingSystem() {
        this. flights = new HashMap<>();
    }

    public void createFlight(String id, int totalSeats) {
        if (id == null || id.trim().isEmpty() || totalSeats <= 0) {
            throw new IllegalArgumentException("Invalid flight id");
        }

        if (flights.containsKey(id)) {
            throw new IllegalArgumentException("Flight id already exists!");
        }

        Flight flight = new Flight(totalSeats);
        flights.put(id, flight);
    }

    public boolean bookSeats(String id, int numSeats) {
        if (!flights.containsKey(id) || numSeats <= 0 || numSeats > 10) {
            return false;
        }

        Flight flight = flights.get(id);
        return flight.bookSeat(numSeats);
    }

    public int getAvailableSeats(String id) {
        if (!flights.containsKey(id)) {
            throw new IllegalArgumentException("Flight id does not exist!");
        }

        Flight flight = flights.get(id);
        return flight.getAvailableSeats();
    }
}
