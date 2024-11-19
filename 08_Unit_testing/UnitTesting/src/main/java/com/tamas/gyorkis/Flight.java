package com.tamas.gyorkis;

public class Flight {
    public int totalSeats;
    public int bookedSeats;

    public Flight(int totalSeats) {
        if (totalSeats <= 0) {
            throw new IllegalArgumentException("Invalid input for total seats");
        }

        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }

    public int getTotalSeats() {
        return totalSeats;
    }
    public int getBookedSeats() {
        return bookedSeats;
    }

    public boolean bookSeat(int numSeats) {
        if (numSeats <= 0 || bookedSeats + numSeats > totalSeats) {
            return false;
        }

        bookedSeats += numSeats;
        return true;
    }

    public int getAvailableSeats() {
        return totalSeats - bookedSeats;
    }
}
