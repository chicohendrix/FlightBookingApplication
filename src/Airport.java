//Flight Booking Application by Ritvik Kumar Kothapalli
//IST 311 - Final
//May 4th 2023

class Airport {
    private int airportID;
    private String airportName;

    public Airport(int airportID, String airportName) {
        this.airportID = airportID;
        this.airportName = airportName;
    }

    // Getters and Setters
    public int getAirportID() {
        return airportID;
    }

    public void setAirportID(int airportID) {
        this.airportID = airportID;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
}