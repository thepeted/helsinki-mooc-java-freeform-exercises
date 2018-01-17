package mooc.airport;

import java.util.ArrayList;
import java.util.HashMap;

public class Airport {
    private HashMap<String, Airplane> airplanes = new HashMap<>();
    private ArrayList<Flight> flights = new ArrayList<>();

    public void addAirplane(Airplane airplane) {
        airplanes.put(airplane.getId(), airplane);
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public HashMap<String, Airplane> getAirplanes() {
        return airplanes;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }
}
