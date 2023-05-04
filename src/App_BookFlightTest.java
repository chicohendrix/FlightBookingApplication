import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class App_BookFlightTest {
    public static void main(String[] args) {
        // Create sample airports
        Airport JFK = new Airport(1, "John F. Kennedy International Airport");
        Airport LAX = new Airport(2, "Los Angeles International Airport");
        Airport ORD = new Airport(3, "O Hare International Airport");

        // Create sample flights
        List<Flight> allFlights = new ArrayList<>();
        allFlights.add(new Flight(1, 1, JFK, LAX, 800, 360));
        allFlights.add(new Flight(2, 1, JFK, ORD, 900, 180));
        allFlights.add(new Flight(3, 1, ORD, LAX, 1300, 240));
        allFlights.add(new Flight(4, 1, JFK, LAX, 1500, 360));
        allFlights.add(new Flight(5, 1, JFK, ORD, 1600, 180));
        allFlights.add(new Flight(6, 1, ORD, LAX, 1900, 240));

        // Create sample traveller
        Traveller ritvik = new Traveller("Ritvik", 3);

        // Instantiate the flight booking application
        App_BookFlight app = new App_BookFlight();

        // Test case 1: Generate multiple routes for Ritvik's trip from JFK to LAX
        ArrayList<ArrayList<Flight>> routes1 = app.generateMultipleRoutes(JFK, LAX, 1, allFlights);
        System.out.println("Test Case 1: Ritvik's available routes from JFK to LAX");
        printRoutes(routes1);

        // Test case 2: Book a ticket for Ritvik using one of the available routes (e.g., option 1)
        Itinerary itinerary1 = app.bookTicket(ritvik, JFK, LAX, 1, allFlights, 0);
        System.out.println("Test Case 2: Ritvik's booked itinerary");
        app.printItinerary(itinerary1);
    }

    public static void printRoutes(ArrayList<ArrayList<Flight>> routes) {
        for (int i = 0; i < routes.size(); i++) {
            System.out.println("Option " + (i + 1) + ":");
            for (Flight flight : routes.get(i)) {
                System.out.println("Flight " + flight.getFlightID() + " from " + flight.getOrigAirport().getAirportName() + " to " + flight.getDestAirport().getAirportName() + " at " + flight.getStartTime());
            }
            System.out.println();
        }
    }
}