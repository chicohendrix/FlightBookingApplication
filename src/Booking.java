//Flight Booking Application by Ritvik Kumar Kothapalli
//IST 311 - Final
//May 4th 2023

class Booking {
    private Traveller traveller;
    private int travelDate;
    private Airport origAirport;
    private Airport destAirport;

    public Booking(Traveller traveller, int travelDate, Airport origAirport, Airport destAirport) {
        this.traveller = traveller;
        this.travelDate = travelDate;
        this.origAirport = origAirport;
        this.destAirport = destAirport;
    }

    // Getters and Setters
    public Traveller getTraveller() {
        return traveller;
    }

    public int getTravelDate() {
        return travelDate;
    }

    public Airport getOrigAirport() {
        return origAirport;
    }

    public Airport getDestAirport() {
        return destAirport;
    }
}