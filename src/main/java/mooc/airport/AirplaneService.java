package mooc.airport;

/**
 * Created by brynach on 17/01/2018.
 */
public class AirplaneService {

    // Start of singleton code - in all modern frameworks, you'd just put @Singleton above the class definition instead
    // For more on what's happening here see https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
    private static final AirplaneService instance = new AirplaneService();

    private AirplaneService() {}

    public static AirplaneService getInstance() {
        return instance;
    }
    // End of singleton code

    Airport airport = Airport.getInstance();

    public Airplane getById(String airplaneId) {

        // This uses Java 8 streams -  very fashionable/functional
        return airport.getAirplanes().stream() // Turning the array into a stream so we can do functional stuff
                .filter(airplane -> airplane.getId().equals(airplaneId)) // applying a filter
                .findFirst().get(); // Getting the first element that matches the above filter
    }
}
