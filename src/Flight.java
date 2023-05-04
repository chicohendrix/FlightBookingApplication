//Flight Booking Application by Ritvik Kumar Kothapalli
//IST 311 - Final
//May 4th 2023

class Flight {
    private int flightID;
    private int flightDate;
    private Airport origAirport;
    private Airport destAirport;
    private int startTime;
    private int duration;

    public Flight(int flightID, int flightDate, Airport origAirport, Airport destAirport, int startTime, int duration) {
        this.flightID = flightID;
        this.flightDate = flightDate;
        this.origAirport = origAirport;
        this.destAirport = destAirport;
        this.startTime = startTime;
        this.duration = duration;
    }

    // Getters and Setters
    public int getFlightID() {
        return flightID;
    }

    public int getFlightDate() {
        return flightDate;
    }

    public Airport getOrigAirport() {
        return origAirport;
    }

    public Airport getDestAirport() {
        return destAirport;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getDuration() {
        return duration;
    }
}
