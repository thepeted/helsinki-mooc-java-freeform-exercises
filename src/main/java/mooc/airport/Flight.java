package mooc.airport;

public class Flight {
    private String destination;
    private String departure;
    private Airplane airplane;

    public Flight(Airplane airplane, String departure, String destination) {
        this.airplane = airplane;
        this.departure = departure;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return airplane.toString() + " (" + departure + "-" + destination + ")";
    }
}
