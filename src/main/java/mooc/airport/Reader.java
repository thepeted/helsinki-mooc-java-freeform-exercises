package mooc.airport;

import java.util.Scanner;

public class Reader {
    private Scanner reader = new Scanner(System.in);

    private static Reader instance = new Reader();

    private Reader() {}

    public static Reader getInstance() { return instance; }

    public String nextLine() {
        return reader.nextLine().trim();
    }

    public char getCommand() {
        return reader.nextLine().trim().charAt(0);
    }
}
