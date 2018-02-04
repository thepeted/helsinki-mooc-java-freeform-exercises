package mooc.airport;

public class Main {

    public static void main(String[] args) {
	    Reader reader = new Reader(); // You could definitely make the reader a singleton too!!
	    TextInterface ui = new TextInterface(reader);
	    ui.start();
    }
}
