package mooc.airport;

public class Main {

    public static void main(String[] args) {
	    Airport airport = new Airport();
	    Reader reader = new Reader();
	    TextInterface ui = new TextInterface(reader, airport);
	    ui.start();
    }
}
