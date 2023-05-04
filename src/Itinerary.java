//Flight Booking Application by Ritvik Kumar Kothapalli
//IST 311 - Final
//May 4th 2023

import java.util.ArrayList;

class Itinerary {
    private Booking booking;
    private ArrayList<Flight> flights;

    public Itinerary(Booking booking, ArrayList<Flight> flights) {
        this.booking = booking;
        this.flights = flights;
    }

    // Getters and Setters
    public Booking getBooking() {
        return booking;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }
}