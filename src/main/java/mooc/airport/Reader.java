package mooc.airport;

import java.util.Scanner;

public class Reader {
    private Scanner reader;

    public Reader() {
        this.reader = new Scanner(System.in);
    }

    public String nextLine() {
        return reader.nextLine().trim();
    }

    public char getCommand() {
        return reader.nextLine().trim().charAt(0);
    }
}
