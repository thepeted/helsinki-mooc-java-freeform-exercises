package mooc.airport;

import java.util.ArrayList;
import java.util.HashMap;

public class TextInterface {
    private Reader reader;
    private Airport airport;

    public TextInterface(Reader reader, Airport airport) {
        this.reader = reader;
        this.airport = airport;
    }

    public void start() {
        airportPanel();
    }

    private void airportPanel() {
        System.out.println("Airport panel");
        System.out.println("--------------------");

        while(true) {
            printAirportPanelInstructions();
            char command = reader.getCommand();

            if (command == 'x') {
                flightPanel();
                break;
            }

            if (command == '1') {
                // Add airplane
                System.out.print("Give plane ID: ");
                String id = reader.nextLine();
                System.out.print("Give plane capacity: ");
                int capacity = Integer.parseInt(reader.nextLine());
                airport.addAirplane(new Airplane(id, capacity));
            }

            if (command == '2') {
                // Add flight
                System.out.print("Give plane ID: ");
                Airplane plane = airport.getAirplanes().get(reader.nextLine());
                System.out.print("Give departure airport code: ");
                String departure = reader.nextLine();
                System.out.print("Give destination airport code: ");
                String destination = reader.nextLine();

                if (plane == null) {
                    System.out.println("The plane ID entered did not match any current Airplanes\n");
                } else {
                    Flight flight = new Flight(plane, departure, destination);
                    airport.addFlight(flight);
                }
            }

        }
    }

    private void flightPanel() {
        System.out.println("Flight panel");
        System.out.println("--------------------");

        while(true) {
            printFlightPanelInstructions();
            char command = reader.getCommand();

            if (command == 'x') {
                break;
            }

            HashMap<String, Airplane> airplanes = airport.getAirplanes();
            ArrayList<Flight> flights = airport.getFlights();

            if (command == '1') {
                // Print planes
                for (String key: airplanes.keySet()) {
                    System.out.println(airplanes.get(key));
                }
            }

            if (command == '2') {
                // Print flights
                for (Flight flight: flights) {
                    System.out.println(flight);
                }
            }

            if (command == '3') {
                // Print plane info
                System.out.print("Give plane ID: ");
                String airplaneId = reader.nextLine();
                Airplane airplane = airplanes.get(airplaneId);

                if (airplane == null) {
                    System.out.println("The plane ID entered did not match any current Airplanes\n");
                } else {
                    System.out.println(airplanes.get(airplaneId));
                }
            }
        }
    }

    private void printAirportPanelInstructions() {
        System.out.println("Choose Operation");
        System.out.println("[1] Add airplane");
        System.out.println("[2] Add flight");
        System.out.println("[x] Exit");
        System.out.print("> ");
    }

    private void printFlightPanelInstructions() {
        System.out.println("Choose Operation");
        System.out.println("[1] Print planes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print plane info");
        System.out.println("[x] Exit");
        System.out.print("> ");
    }
}
