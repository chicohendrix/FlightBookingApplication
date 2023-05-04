import java.util.*;
//Flight Booking Application by Ritvik Kumar Kothapalli
//IST 311 - Final
//May 4th 2023

class Traveller {
    private String name;
    private int travellerID;

    public Traveller(String name, int travellerID) {
        this.name = name;
        this.travellerID = travellerID;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTravellerID() {
        return travellerID;
    }

    public void setTravellerID(int travellerID) {
        this.travellerID = travellerID;
    }
}