import java.util.ArrayList;
import java.util.List;

//Flight Booking Application by Ritvik Kumar Kothapalli
//IST 311 - Final
//May 4th 2023


class App_BookFlight {
    private static final int MINIMUM_TRANSIT_TIME = 60;
    private static final int HOURLY_RATE = 100;

    public ArrayList<ArrayList<Flight>> generateMultipleRoutes(Airport origAirport, Airport destAirport, int date, List<Flight> allFlights) {
        ArrayList<ArrayList<Flight>> routes = new ArrayList<>();

        for (Flight flight : allFlights) {
            if (flight.getOrigAirport().equals(origAirport) && flight.getDestAirport().equals(destAirport)) {
                ArrayList<Flight> directRoute = new ArrayList<>();
                directRoute.add(flight);
                routes.add(directRoute);
            } else if (flight.getOrigAirport().equals(origAirport)) {
                for (Flight connectingFlight : allFlights) {
                    if (flight.getDestAirport().equals(connectingFlight.getOrigAirport()) &&
                            flight.getFlightDate() == connectingFlight.getFlightDate() &&
                            flight.getStartTime() + flight.getDuration() + MINIMUM_TRANSIT_TIME <= connectingFlight.getStartTime() &&
                            connectingFlight.getDestAirport().equals(destAirport)) {

                        ArrayList<Flight> indirectRoute = new ArrayList<>();
                        indirectRoute.add(flight);
                        indirectRoute.add(connectingFlight);
                        routes.add(indirectRoute);
                    }
                }
            }
        }

        return routes;
    }
    public Itinerary bookTicket(Traveller traveller, Airport origAirport, Airport destAirport, int date, List<Flight> allFlights, int selectedOption) {
        ArrayList<ArrayList<Flight>> routes = generateMultipleRoutes(origAirport, destAirport, date, allFlights);
        ArrayList<Flight> selectedFlights = routes.get(selectedOption);

        Booking booking = new Booking(traveller, date, origAirport, destAirport);
        return new Itinerary(booking, selectedFlights);
    }

    public void printItinerary(Itinerary itinerary) {
        System.out.println("Traveller: " + itinerary.getBooking().getTraveller().getName());
        System.out.println("Travel Date: " + itinerary.getBooking().getTravelDate());
        System.out.println("Origin: " + itinerary.getBooking().getOrigAirport().getAirportName());
        System.out.println("Destination: " + itinerary.getBooking().getDestAirport().getAirportName());
        System.out.println("\nFlights:\n");

        int totalDuration = 0;
        for (Flight flight : itinerary.getFlights()) {
            System.out.println("Flight " + flight.getFlightID() + " from " + flight.getOrigAirport().getAirportName() + " to " + flight.getDestAirport().getAirportName() + " at " + flight.getStartTime() + " (duration: " + flight.getDuration() + " minutes)");
            totalDuration += flight.getDuration();
        }

        int fareAmount = (totalDuration / 60) * HOURLY_RATE;
        System.out.println("\nTotal Fare: USD " + fareAmount);
    }

    public static void main(String[] args) {
        // Create airports
        Airport JFK = new Airport(1, "John F. Kennedy International Airport");
        Airport LAX = new Airport(2, "Los Angeles International Airport");
        Airport ORD = new Airport(3, "O Hare International Airport");

        // Create flights
        List<Flight> allFlights = new ArrayList<>();
        allFlights.add(new Flight(1, 1, JFK, LAX, 800, 360));
        allFlights.add(new Flight(2, 1, JFK, ORD, 900, 180));
        allFlights.add(new Flight(3, 1, ORD, LAX, 1300, 240));
        allFlights.add(new Flight(4, 1, JFK, LAX, 1500, 360));
        allFlights.add(new Flight(5, 1, JFK, ORD, 1600, 180));
        allFlights.add(new Flight(6, 1, ORD, LAX, 1900, 240));

        // Create traveller
        Traveller alice = new Traveller("Donald Johnson", 1);

        // Instantiate the flight booking application
        App_BookFlight app = new App_BookFlight();

        // Generate multiple routes for the traveller
        ArrayList<ArrayList<Flight>> routes = app.generateMultipleRoutes(JFK, LAX, 1, allFlights);

        // Print all available routes
        for (int i = 0; i < routes.size(); i++) {
            System.out.println("Option " + (i + 1) + ":");
            for (Flight flight : routes.get(i)) {
                System.out.println("Flight " + flight.getFlightID() + " from " + flight.getOrigAirport().getAirportName() + " to " + flight.getDestAirport().getAirportName() + " at " + flight.getStartTime());
            }
            System.out.println();
        }

        // Book a ticket for the traveller using one of the available routes
        Itinerary itinerary = app.bookTicket(alice, JFK, LAX, 1, allFlights, 0);

        // Print the booked itinerary
        app.printItinerary(itinerary);


        ///TEST////////////TEST/////////TEST////////////TEST//////////TEST//////////TEST////////////////////
        // Test case 1: Add more flights and try generating multiple routes for another traveller
        allFlights.add(new Flight(7, 1, JFK, ORD, 1200, 180));
        allFlights.add(new Flight(8, 1, ORD, LAX, 1500, 240));
        Traveller bob = new Traveller("Bob", 2);
        ArrayList<ArrayList<Flight>> routes2 = app.generateMultipleRoutes(JFK, LAX, 1, allFlights);
        for (int i = 0; i < routes2.size(); i++) {
            System.out.println("Option " + (i + 1) + ":");
            for (Flight flight : routes2.get(i)) {
                System.out.println("Flight " + flight.getFlightID() + " from " + flight.getOrigAirport().getAirportName() + " to " + flight.getDestAirport().getAirportName() + " at " + flight.getStartTime());
            }
            System.out.println();
        }
    }
}