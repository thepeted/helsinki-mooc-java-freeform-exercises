package mooc.airport;

import java.util.ArrayList;
import java.util.HashMap;

public class Airport {
    private ArrayList<Airplane> airplanes = new ArrayList<>();
    private ArrayList<Flight> flights = new ArrayList<>();

    // Start of singleton code - in all modern frameworks, you'd just put @Singleton above the class definition instead
    // For more on what's happening here see https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
    private static final Airport instance = new Airport();

    private Airport() {}

    public static Airport getInstance() {
        return instance;
    }
    // End of singleton code

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public ArrayList<Airplane> getAirplanes() {
        return airplanes;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }
}
